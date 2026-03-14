package com.bootcamp.project_stock_data.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.project_stock_data.entity.StockEntity;
import com.bootcamp.project_stock_data.mapper.StockMapper;
import com.bootcamp.project_stock_data.model.StockDTO;
import com.bootcamp.project_stock_data.service.StockService;

public class StockController {
@Autowired
private StockMapper stockMapper;
  @Autowired
  private StockService stockService;
  
  public StockDTO getStock(@RequestParam String symbol){
      StockEntity stockEntity = this.stockService.getStock(symbol);
  return this.stockMapper.map(stockEntity);
                 
  }
}
