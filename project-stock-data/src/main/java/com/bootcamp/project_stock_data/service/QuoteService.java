package com.bootcamp.project_stock_data.service;

import java.util.List;

import com.bootcamp.project_stock_data.entity.QuoteEntity;

public interface QuoteService {


  void updateQuotes() throws InterruptedException;

  List<QuoteEntity> findAll();

    
  
}
