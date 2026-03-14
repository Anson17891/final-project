package com.bootcamp.project_stock_data.service;

import com.bootcamp.project_stock_data.entity.StockEntity;

public interface StockService {
  StockEntity getStock(String symbol);
}
