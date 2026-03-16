package com.bootcamp.project_stock_data.service;

import java.util.List;

import com.bootcamp.project_stock_data.entity.OhlcEntity;



public interface OhlcService {
  List<OhlcEntity> getOhlcsBySymbol(String symbol);
  
  void deleteAll(); 

  // update ohlc everyday; 
  //1.find today's ohlc for 500stocks
  //2. save in db 

}
