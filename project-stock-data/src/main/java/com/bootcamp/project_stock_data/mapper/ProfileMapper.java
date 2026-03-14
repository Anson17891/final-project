package com.bootcamp.project_stock_data.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootcamp.project_stock_data.entity.ProfileEntity;
import com.bootcamp.project_stock_data.entity.StockEntity;
import com.bootcamp.project_stock_data.model.CompanyDTO;
import com.bootcamp.project_stock_data.model.ProfileDTO;
import com.bootcamp.project_stock_data.service.StockService;

@Component
public class ProfileMapper {

  @Autowired
  private StockService stockService;
    
  public ProfileEntity map(CompanyDTO companyDTO, String symbol){
      StockEntity stockEntity = this.stockService.getStock(symbol);

    return ProfileEntity.builder()//
                        .name(companyDTO.getName())//
                        .logo(companyDTO.getLogo())//
                        .symbol(companyDTO.getTicker())//
                        .marketCapitalization(companyDTO.getMarketCapitalization())//
                        .shareOutstanding(companyDTO.getShareOutstanding())//
                        .finnhubIndustry(companyDTO.getFinnhubIndustry())//
                        .weburl(companyDTO.getWeburl())//
                        .country(companyDTO.getCountry())//
                        .phone(companyDTO.getPhone())//
                        .estimateCurrency(companyDTO.getEstimateCurrency())//
                        .exchange(companyDTO.getExchange())//
                        .currency(companyDTO.getCurrency())//
                        .ipo(companyDTO.getIpo())//
                        .stockEntity(stockEntity)// 
                        .build();

  }

  public ProfileDTO map(ProfileEntity profileEntity){
    return ProfileDTO.builder()//
                      .name(profileEntity.getName())//
                      .symbol(profileEntity.getSymbol())//
                      .logo(profileEntity.getLogo())//
                      .marketCapitalization(profileEntity.getMarketCapitalization())//
                      .shareOutstanding(profileEntity.getShareOutstanding())//
                      .industry(profileEntity.getFinnhubIndustry())//
                      .country(profileEntity.getCountry())//
                      .phone(profileEntity.getPhone())//
                      .weburl(profileEntity.getWeburl())//
                      .estimateCurrency(profileEntity.getEstimateCurrency())//
                      .exchange(profileEntity.getExchange())//
                      .currency(profileEntity.getCurrency())//
                      .ipo(profileEntity.getIpo())//
                      .build();
  }
}
