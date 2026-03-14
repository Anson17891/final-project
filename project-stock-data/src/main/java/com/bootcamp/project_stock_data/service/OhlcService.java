package com.bootcamp.project_stock_data.service;

import java.util.List;

import com.bootcamp.project_stock_data.entity.OhlcEntity;



public interface OhlcService {
  List<OhlcEntity> getOhlcs(String symbol);

  void deleteAll();  //! plan to run once a day before import new ohlc (by python), USING @SCHEDULE
}
