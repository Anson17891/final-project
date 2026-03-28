package com.bootcamp.project_stock_data.service.impl;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.bootcamp.project_stock_data.codeLib.RedisManager;
import com.bootcamp.project_stock_data.entity.ProfileEntity;
import com.bootcamp.project_stock_data.mapper.ProfileMapper;
import com.bootcamp.project_stock_data.mapper.UrlManager;
import com.bootcamp.project_stock_data.model.CompanyDTO;
import com.bootcamp.project_stock_data.repository.ProfileRepository;
import com.bootcamp.project_stock_data.repository.StockRepository;
import com.bootcamp.project_stock_data.service.ProfileService;
import com.bootcamp.project_stock_data.service.StockService;
import com.google.common.util.concurrent.RateLimiter;


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
  @Autowired
  private StockService stockService;


   //step1. get symbol ,save profileEntity (call from starter?)
@Override
public List<ProfileEntity> saveAllProfiles() throws InterruptedException {
    List<ProfileEntity> profiles = new ArrayList<>();
    List<String> symbols = this.stockRepository.findAllSymbols();

    RateLimiter rateLimiter = RateLimiter.create(0.9);  //control call rate ,thx ai...|||OTZ
    int batchSize = 60;  //prevent "all or nothing"

    int uploadCounter = 0;

    for (String s : symbols) {
      //Testing
      System.out.println(s + "-is processing");

        rateLimiter.acquire();

        try {
            CompanyDTO companyDTO = this.urlManager.getCompanyDTO(s);
            if (companyDTO != null) {

                ProfileEntity profileEntity = this.profileMapper.mapToEntity(companyDTO, s);
                profiles.add(profileEntity);
//Testing
System.out.println(profileEntity.getSymbol() + "-is added");
            }
        } catch (HttpClientErrorException.TooManyRequests e) {
            System.out.println("API limit reached, pausing for 1 minute...");
            Thread.sleep(60_000);
        } catch (Exception e) {
            System.out.println("Error fetching profile for " + s + ": " + e.getMessage());
        }

        if (profiles.size() >= batchSize) {

            this.profileRepository.saveAll(profiles);

            uploadCounter+=profiles.size();
            System.out.println(uploadCounter + " out of "+ symbols.size() + " stocks' profile uploaded");

            profiles.clear();
        }
    }

    if (!profiles.isEmpty()) {
        this.profileRepository.saveAll(profiles);
    }

    uploadCounter = 0;

    return profiles;
}

  @Override
  public ProfileEntity getProfileEntity(String symbol){
  ProfileEntity profileEntity= this.redisManager.get("profile:" + symbol,ProfileEntity.class); //! changed key, prevent crush with OhlcEntity
  if(profileEntity != null){
    return profileEntity;
  }
  else{
    profileEntity = this.profileRepository.findBySymbol(symbol)//
      .orElse(null);
      this.redisManager.set("profile:" + symbol, profileEntity, Duration.ofHours(24));
  
  return profileEntity;
}
}

@Override
public void deleteAll(){
  this.profileRepository.deleteAll();
  
}
  }
  

