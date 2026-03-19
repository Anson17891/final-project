package com.bootcamp.project_stock_data.service.impl;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.project_stock_data.codeLib.RedisManager;
import com.bootcamp.project_stock_data.entity.OhlcEntity;
import com.bootcamp.project_stock_data.repository.OhlcRepository;
import com.bootcamp.project_stock_data.service.OhlcService;
@Service
public class OhlcServiceImpl implements OhlcService{
@Autowired
  private OhlcRepository ohlcRepository;
@Autowired
private RedisManager redisManager;




// @Override
// public List<OhlcEntity> getOhlcs(String symbol){   //! may be use redis?
//   return this.ohlcRepository.findBySymbol(symbol);
// }
  @Override
  public List<OhlcEntity> getOhlcsBySymbol(String symbol){
  List<OhlcEntity> ohlcs= this.redisManager.getList("ohlc:" + symbol,OhlcEntity.class);  //! changed key, prevent crush with profileEntity
  if(ohlcs != null){
    return ohlcs;
  }
  else{
    ohlcs = this.ohlcRepository.findAllByStock_SymbolOrderByTranDateDesc(symbol);
      this.redisManager.set("ohlc:" + symbol, ohlcs, Duration.ofSeconds(30L));
  
  return ohlcs;
}
}

@Override
public void deleteAll(){
  this.ohlcRepository.deleteAll();
}
}
