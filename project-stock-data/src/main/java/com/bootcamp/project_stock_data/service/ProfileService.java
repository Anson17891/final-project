package com.bootcamp.project_stock_data.service;

import java.util.List;

import com.bootcamp.project_stock_data.entity.ProfileEntity;

public interface ProfileService {

    //step1. save stockEntity (call from starter?)

  List<ProfileEntity> saveAllProfiles() throws InterruptedException;


  // StockEntity getStockEntity(String symbol);
  ProfileEntity getProfileEntity(String symbol);

  void deleteAll();
}
