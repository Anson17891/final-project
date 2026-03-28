package com.bootcamp.project_stock_data.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootcamp.project_stock_data.dto.ProfileDto;
import com.bootcamp.project_stock_data.entity.ProfileEntity;
import com.bootcamp.project_stock_data.model.CompanyDTO;
import com.bootcamp.project_stock_data.model.ProfileDTO;
import com.bootcamp.project_stock_data.service.StockService;

@Component
public class ProfileMapper {

  @Autowired
  private StockService stockService;
    
  public ProfileEntity mapToEntity(CompanyDTO companyDTO, String symbol){


    return ProfileEntity.builder()//
                        .name(companyDTO.getName())//
                        .logo(companyDTO.getLogo())//
                        .symbol(symbol)//
                        .marketCapitalization(companyDTO.getMarketCapitalization())//
                        .shareOutstanding(companyDTO.getShareOutstanding())//
                        .industry(companyDTO.getIndustry())//
                        .weburl(companyDTO.getWeburl())//
                        .country(companyDTO.getCountry())//
                        .phone(companyDTO.getPhone())//
                        .estimateCurrency(companyDTO.getEstimateCurrency())//
                        .exchange(companyDTO.getExchange())//
                        .currency(companyDTO.getCurrency())//
                        .ipo(companyDTO.getIpo())//
                        // .stockEntity(stockEntity)// 
                        .build();

  }

  public ProfileDTO mapToDTO(ProfileEntity profileEntity){
    return ProfileDTO.builder()//
                      .name(profileEntity.getName())//
                      .symbol(profileEntity.getSymbol())//
                      .logo(profileEntity.getLogo())//
                      .marketCapitalization(profileEntity.getMarketCapitalization())//
                      .shareOutstanding(profileEntity.getShareOutstanding())//
                      .industry(profileEntity.getIndustry())//
                      .country(profileEntity.getCountry())//
                      .phone(profileEntity.getPhone())//
                      .weburl(profileEntity.getWeburl())//
                      .estimateCurrency(profileEntity.getEstimateCurrency())//
                      .exchange(profileEntity.getExchange())//
                      .currency(profileEntity.getCurrency())//
                      .ipo(profileEntity.getIpo())//
                      .build();
  }
 
  public ProfileDto mapToDto(ProfileEntity profileEntity){
        return ProfileDto.builder()//
                      .name(profileEntity.getName())//
                      .symbol(profileEntity.getSymbol())//
                      .logo(profileEntity.getLogo())//
                      .marketCapitalization(profileEntity.getMarketCapitalization())//
                      .shareOutstanding(profileEntity.getShareOutstanding())//
                      .industry(profileEntity.getIndustry())//
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
