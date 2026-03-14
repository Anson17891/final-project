package com.bootcamp.project_stock_data.service;

import com.bootcamp.project_stock_data.entity.ProfileEntity;

public interface ProfileService {

    //step1. save stockEntity (call from starter?)

  void saveProfileEntities();


  // StockEntity getStockEntity(String symbol);
  ProfileEntity getProfileEntity(String symbol);

}
