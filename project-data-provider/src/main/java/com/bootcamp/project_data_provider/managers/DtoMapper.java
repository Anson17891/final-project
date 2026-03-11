package com.bootcamp.project_data_provider.managers;

import org.springframework.stereotype.Component;
import com.bootcamp.project_data_provider.dto.DataDto;
import com.bootcamp.project_data_provider.model.CompanyDTO;
import com.bootcamp.project_data_provider.model.StockDTO;

@Component
public class DtoMapper {
  public DataDto map(CompanyDTO companyDTO, StockDTO stockDTO){
    return DataDto.builder()//
                  .symbol(companyDTO.getTicker())//
                  .name(companyDTO.getName())//
                  .industry(companyDTO.getFinnhubIndustry())//
                  .logo(companyDTO.getLogo())//
                  .marketCapitalization(companyDTO.getMarketCapitalization())//
                  .share(companyDTO.getShareOutstanding())//
                  .currentPrice(stockDTO.getCurrentPrice())//
                  .change(stockDTO.getChange())//
                  .percentChange(stockDTO.getPercentChange())//
                  .tradeVolume(stockDTO.getTradeVolume())//
                  .build();

  }
}
