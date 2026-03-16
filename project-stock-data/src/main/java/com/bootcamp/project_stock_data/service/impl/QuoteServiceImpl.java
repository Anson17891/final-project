package com.bootcamp.project_stock_data.service.impl;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.bootcamp.project_stock_data.codeLib.RedisManager;
import com.bootcamp.project_stock_data.entity.QuoteEntity;
import com.bootcamp.project_stock_data.mapper.QuoteMapper;
import com.bootcamp.project_stock_data.mapper.UrlManager;
import com.bootcamp.project_stock_data.model.QuoteDTO;
import com.bootcamp.project_stock_data.repository.QuoteRepository;
import com.bootcamp.project_stock_data.repository.StockRepository;
import com.bootcamp.project_stock_data.service.QuoteService;

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


  private int batchIndex = 0;
  private List<QuoteDTO> result = new ArrayList<>();
  
  @Scheduled(fixedRate = 1000) //every second run once
  @Override
  public void updateQuotes(){  //!target: update every certain time period
    List<QuoteDTO> quotes = new ArrayList<>();
    List<String> symbols = this.stockRepository.findAllSymbols();
    int batchSize = 25;                       //!thx ai... |||OTZ
    int totalBatches = (int) Math.ceil((double) symbols.size() / batchSize);
    int start = batchIndex * batchSize;
    int end = Math.min(start+batchSize, symbols.size());
    List<String> symbolSubList = symbols.subList(start,end);
    for(String s: symbolSubList){
      try{
    QuoteDTO quoteDTO = this.urlManager.getQuoteDTO(s);
    quotes.add(quoteDTO);
      }catch( Exception e){System.out.println("Failed to get quote from symbol:" + s);}
  }
    result.addAll(quotes);

    batchIndex++;
    if (batchIndex >= totalBatches) {
      List<QuoteEntity> quoteEntities = result.stream().map(e -> this.quoteMapper.map(e)).toList();
      this.quoteRepository.saveAll(quoteEntities);
      this.redisManager.set("quotes:all", result, Duration.ofSeconds(120));
            batchIndex = 0; 
            result.clear();
  }
  
}
}


//!update real-time -> put in db?
//!finnhub limitation: 30calls/sec  ->  ~18sec for 500stocks
//!can use @schedule to real-time update???
//!  1. for loop-> get List<quote> from symbols
//!  2. save in db/redis
//!  3.  

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