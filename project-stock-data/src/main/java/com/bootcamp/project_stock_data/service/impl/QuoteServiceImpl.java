package com.bootcamp.project_stock_data.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.project_stock_data.mapper.UrlManager;
import com.bootcamp.project_stock_data.model.QuoteDTO;
import com.bootcamp.project_stock_data.repository.StockRepository;
import com.bootcamp.project_stock_data.service.QuoteService;

@Service
public class QuoteServiceImpl implements QuoteService{
  @Autowired
private UrlManager urlManager;
  @Autowired
  private StockRepository stockRepository;

  @Override
  public List<QuoteDTO> getQuotes(){  //!target: update every certain time period  ()
    List<QuoteDTO> quotes = new ArrayList<>();
    List<String> symbols = this.stockRepository.getAllSymbols();
    for(String s: symbols){
    QuoteDTO quoteDTO = this.urlManager.getQuoteDTO(s);
    quotes.add(quoteDTO);
  }
  return quotes;
  }
}

/
//!update real-time -> put in db?
//!finnhub limitation: 60calls/min  ->  ~8.5min for 500stocks
//!can use @schedule to real-time update???
//!  1. for loop-> get List<quote> from symbols
//!  2. save in db
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
// - Instead of the frontend polling getQuotes(), use Server-Sent Events (SSE) or WebSockets.
// - Whenever new quotes are fetched, the backend pushes them to connected clients.
// - The frontend heatmap listens for updates and re-renders automatically.
// - The frontend subscribes to /quotes/stream and updates the heatmap in real time.
// - 3. Frontend Integration
// - In JavaScript/React/Vue:



