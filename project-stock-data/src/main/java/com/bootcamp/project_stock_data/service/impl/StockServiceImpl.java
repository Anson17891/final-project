package com.bootcamp.project_stock_data.service.impl;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.project_stock_data.codeLib.RedisManager;
import com.bootcamp.project_stock_data.entity.StockEntity;
import com.bootcamp.project_stock_data.repository.StockRepository;
import com.bootcamp.project_stock_data.service.StockService;

@Service
public class StockServiceImpl implements StockService{
  @Autowired
  private StockRepository stockRepository;
  @Autowired
  private RedisManager redisManager;
//-----------------------------
@Override
public StockEntity getStock(String symbol){
  StockEntity stockEntity= this.redisManager.get(symbol,StockEntity.class);
  if(stockEntity != null){
    return stockEntity;
  }
  else{
    stockEntity = this.stockRepository.findBySymbol(symbol)//
                             .orElseThrow(()-> new NoSuchElementException("symbol not found"));
      this.redisManager.set(symbol, stockEntity, Duration.ofSeconds(30L));  //ai: suggest to use application.yml to store duration time
  
  return stockEntity;
}
}

//-----------------------------
  // @Override
  // public StockEntity getStock(String symbol){
  //   return this.stockRepository.findBySymbol(symbol).orElseThrow(()-> new NoSuchElementException("Symbol not found : " + symbol));
  // }

  @Override
  public List<StockEntity> getAllStocks(){
    return this.stockRepository.findAll();
  }

  @Override
  public void deleteAll(){
    this.stockRepository.deleteAll();
  }
}
