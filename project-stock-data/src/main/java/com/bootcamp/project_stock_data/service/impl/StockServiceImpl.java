package com.bootcamp.project_stock_data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.project_stock_data.entity.StockEntity;
import com.bootcamp.project_stock_data.repository.StockRepository;
import com.bootcamp.project_stock_data.service.StockService;

public class StockServiceImpl implements StockService{
  @Autowired
  private StockRepository stockRepository;
  //-----------------------------
  // @Override
  // public StockEntity getStockEntity(String symbol){
//   StockEntity stockEntity= this.redisManager.get(symbol,StockEntity.class);
//   if(stockEntity != null){
//     return stockEntity;
//   }
//   else{
//     stockEntity = this.stockRepository.findBySymbol(symbol)//
//                              .orElseThrow(()-> new IllegalArgumentException("symbol not found"));
//       this.redisManager.set(symbol, stockEntity, Duration.ofSeconds(30L));
  
//   return stockEntity;
// }
// }

//-----------------------------
  @Override
  public StockEntity getStock(String symbol){
    return this.stockRepository.findBySymbol(symbol).orElseThrow(()-> new IllegalStateException("Symbol not found : " + symbol));
  }
}
