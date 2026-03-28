package com.bootcamp.project_stock_data.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bootcamp.project_stock_data.service.QuoteService;

@Component
public class AppScheduler {
  @Autowired
  private QuoteService quoteService;
  



  @Scheduled(fixedRate= 60000)
    public void updateQuotes() throws InterruptedException{
    this.quoteService.updateQuotes();
  System.out.println("Quotes updated...");
  }
}
