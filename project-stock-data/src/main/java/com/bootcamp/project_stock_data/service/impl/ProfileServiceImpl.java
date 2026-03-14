package com.bootcamp.project_stock_data.service.impl;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.project_stock_data.codeLib.RedisManager;
import com.bootcamp.project_stock_data.entity.ProfileEntity;
import com.bootcamp.project_stock_data.mapper.ProfileMapper;
import com.bootcamp.project_stock_data.mapper.UrlManager;
import com.bootcamp.project_stock_data.model.CompanyDTO;
import com.bootcamp.project_stock_data.repository.ProfileRepository;
import com.bootcamp.project_stock_data.repository.StockRepository;
import com.bootcamp.project_stock_data.service.ProfileService;


@Service
public class ProfileServiceImpl implements ProfileService{
  @Autowired
  private ProfileRepository profileRepository;
  @Autowired
  private StockRepository stockRepository;
  @Autowired
  private UrlManager urlManager; 
  @Autowired
  private ProfileMapper profileMapper;
  @Autowired
  private RedisManager redisManager;


   //step1. get symbol ,save profileEntity (call from starter?)
  @Override
  public void saveProfileEntities(){
      List<ProfileEntity> profiles = new ArrayList<>();
      List<String> symbols = this.stockRepository.getAllSymbols();
          for(String s: symbols){
            CompanyDTO companyDTO = this.urlManager.getCompanyDTO(s);
            ProfileEntity profileEntity = this.profileMapper.map(companyDTO,s);
            profiles.add(profileEntity);
            
  }
  this.profileRepository.saveAll(profiles);

  }

  @Override
  public ProfileEntity getProfileEntity(String symbol){
  ProfileEntity profileEntity= this.redisManager.get("profile:" + symbol,ProfileEntity.class); //! changed key, prevent crush with OhlcEntity
  if(profileEntity != null){
    return profileEntity;
  }
  else{
    profileEntity = this.profileRepository.findBySymbol(symbol)//
      .orElseThrow(()-> new IllegalArgumentException("symbol not found"));
      this.redisManager.set("profile:" + symbol, profileEntity, Duration.ofSeconds(30L));
  
  return profileEntity;
}
}
  }
  

