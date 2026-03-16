package com.bootcamp.project_stock_data.service;

import java.util.List;

import com.bootcamp.project_stock_data.entity.StockEntity;

public interface StockService {
  StockEntity getStock(String symbol);
  List<StockEntity> getAllStocks();

  void deleteAll();
}
