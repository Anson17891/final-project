package com.bootcamp.project_stock_data.service.impl;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.bootcamp.project_stock_data.codeLib.RedisManager;
import com.bootcamp.project_stock_data.entity.QuoteEntity;
import com.bootcamp.project_stock_data.mapper.QuoteMapper;
import com.bootcamp.project_stock_data.mapper.UrlManager;
import com.bootcamp.project_stock_data.model.QuoteDTO;
import com.bootcamp.project_stock_data.repository.QuoteRepository;
import com.bootcamp.project_stock_data.repository.StockRepository;
import com.bootcamp.project_stock_data.service.QuoteService;
import com.google.common.util.concurrent.RateLimiter;

@Service
public class QuoteServiceImpl implements QuoteService{
  @Autowired
private UrlManager urlManager;
  @Autowired
  private StockRepository stockRepository;
  @Autowired
  private RedisManager redisManager;
  @Autowired
  private QuoteRepository quoteRepository;
  @Autowired
  private QuoteMapper quoteMapper;

//!update real-time -> put in db?
//!finnhub limitation: 30calls/sec + 60calls/minute ->  >8 min/500stocks
//!method 1 . update batch by batch (eg.60calls)
//!method 2. update whole 500stocks data 8min before
//!method 3. multiple source + thread

  @Override
  public void updateQuotes() throws InterruptedException{
    List<String> symbols = this.stockRepository.findAllSymbols();
    // List<QuoteDTO> quotes = new ArrayList<>();
    

    int batchSize = 55;
    int batchNumber = (int)Math.ceil(symbols.size()/(double)batchSize);

    int updatedQuotes =  0;

    RateLimiter rateLimiter = RateLimiter.create(0.9);

    for(int i = 0; i<batchNumber; i++){

      List<QuoteDTO> batch = new ArrayList<>();

    for(int j = 0+(i*batchSize); j<Math.min((i + 1) * batchSize, symbols.size());j++){
      String s = symbols.get(j);

      rateLimiter.acquire();
      try {
          QuoteDTO quoteDTO = this.urlManager.getQuoteDTO(s);
          batch.add(quoteDTO);
      }catch (HttpClientErrorException.TooManyRequests e) {
            System.out.println("API limit reached, pausing for 1 minute...");
            Thread.sleep(60_000);
        }  catch (Exception e) {
        System.out.println("Failed to get quote from symbol:" + s);
      }
    }
    // quotes.addAll(batch);
    List<QuoteEntity> quoteEntities = batch.stream().map(e -> this.quoteMapper.mapToEntity(e)).toList();
    updatedQuotes += batch.size();
    
    this.quoteRepository.saveAll(quoteEntities);
    for(QuoteEntity q : quoteEntities){
      this.redisManager.setByHash("quotes:all", q.getSymbol(), q, Duration.ofMinutes(10));
    }
      System.out.println(updatedQuotes + "/" + symbols.size() + " quotes have updated...");
  }
  
      
      // this.quoteRepository.deleteAll(); //!no duplicate quote...can use Map<>?
      

  // quotes.clear();

  }  //! follow up: incremental update( batch by batch)
  //! 1. write a redisManager.setByHash(), use opsForHash().put()
     // opsForHash: store by hash of each stock-> update old,add new
  //! 2.  change updateQuotes(), update batch by batch
  //! outcome: real-time update 55 stocks / min, total need ~9min for all 500 stocks 

@Override
public List<QuoteEntity> findAll() {
    List<QuoteEntity> quoteEntities = new ArrayList<>();
    List<String> symbols = this.stockRepository.findAllSymbols();

    List<String> missingSymbols = new ArrayList<>();

    for (String s : symbols) {
        QuoteEntity cached = this.redisManager.getByHash("quotes:all", s, QuoteEntity.class);
        if (cached != null) {
            quoteEntities.add(cached);
        } else {
            missingSymbols.add(s);
        }
    }


    if (!missingSymbols.isEmpty()) {
        List<QuoteEntity> dbQuotes = this.quoteRepository.findAllBySymbolIn(missingSymbols);
        quoteEntities.addAll(dbQuotes);
    }
return quoteEntities;
}
}

  // private int batchIndex = 0;
  // private List<QuoteDTO> result = new ArrayList<>();
  
  // @Scheduled(fixedRate = 30000) //every second run once
  // @Override
  // public void updateQuotes(){  //!target: update every certain time period
  //   List<QuoteDTO> quotes = new ArrayList<>();

  //   List<String> symbols = this.stockRepository.findAllSymbols();

  //   int batchSize = 25;                       //!thx ai... |||OTZ
  //   int totalBatches = (int) Math.ceil((double) symbols.size() / batchSize);
  //   int start = batchIndex * batchSize;
  //   int end = Math.min(start+batchSize, symbols.size());
  //   List<String> symbolSubList = symbols.subList(start,end);
  //   for(String s: symbolSubList){
  //     try{
  //   QuoteDTO quoteDTO = this.urlManager.getQuoteDTO(s);
  //   quotes.add(quoteDTO);
    
  //     }catch( Exception e){System.out.println("Failed to get quote from symbol:" + s);}
  // }
  //   result.addAll(quotes);

  //   batchIndex++;
  //   if (batchIndex >= totalBatches) {
  //     List<QuoteEntity> quoteEntities = result.stream().map(e -> this.quoteMapper.map(e)).toList();
  //     this.quoteRepository.saveAll(quoteEntities);
  //     this.redisManager.set("quotes:all", result, Duration.ofMinutes(3));
  //           batchIndex = 0; 
  //           result.clear();
  // }
  
// }


//ai:  1.Enable Scheduling (done)
//     2.Use @Scheduled for Periodic Updates
//     3. Decide Where to Store Quotes
//       Option A: Save them in your database each time updateQuotes() runs.
//         Option B: Keep them in an in-memory cache (like a ConcurrentHashMap or Redis) for fast retrieval.
//     4. Flexible Scheduling
//          Instead of fixedRate, you can use:
//        - fixedDelay → waits after completion before next run.
//        - cron → for more complex schedules, e.g. "0 0 9 * * MON-FRI" for weekdays at 9 AM.
//  Real-Time Data Flow
// - 1.Backend Scheduled Updates
// - Use @Scheduled (Spring) to fetch quotes periodically and store them in memory or a database.
// - This ensures your backend always has fresh data.
// - 2.Push to Frontend
//! - Instead of the frontend polling getQuotes(), use Server-Sent Events (SSE) or WebSockets.
// - Whenever new quotes are fetched, the backend pushes them to connected clients.
// - The frontend heatmap listens for updates and re-renders automatically.
// - The frontend subscribes to /quotes/stream and updates the heatmap in real time.
// - 3. Frontend Integration
// - In JavaScript/React/Vue:



//! finnhub: Get real-time quote data for US stocks. Constant polling is not recommended. Use WEBSOCKET if you need real-time updates.