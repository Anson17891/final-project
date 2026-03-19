package com.bootcamp.project_data_provider.managers;

import org.springframework.stereotype.Component;

import com.bootcamp.project_data_provider.dto.CompanyDto;
import com.bootcamp.project_data_provider.dto.DataDto;
import com.bootcamp.project_data_provider.dto.QuoteDto;
import com.bootcamp.project_data_provider.model.CompanyDTO;
import com.bootcamp.project_data_provider.model.QuoteDTO;

@Component
public class DtoMapper {
  public CompanyDto mapCompany(CompanyDTO companyDTO){
    return CompanyDto.builder()//
                  .symbol(companyDTO.getTicker())//
                  .name(companyDTO.getName())//
                  .industry(companyDTO.getFinnhubIndustry())//
                  .logo(companyDTO.getLogo())//
                  .marketCapitalization(companyDTO.getMarketCapitalization())//
                  .shareOutstanding(companyDTO.getShareOutstanding())//
                  .country(companyDTO.getCountry())//
                  .currency(companyDTO.getCurrency())//
                  .estimateCurrency(companyDTO.getEstimateCurrency())//
                  .exchange(companyDTO.getExchange())//
                  .ipo(companyDTO.getIpo())//
                  .phone(companyDTO.getPhone())//
                  .weburl(companyDTO.getWeburl())//
                  .build();
  }

  public QuoteDto mapQuote(QuoteDTO quoteDTO, String symbol){
    return QuoteDto.builder()//
                  .symbol(symbol)//
                  .currentPrice(quoteDTO.getCurrentPrice())//
                  .change(quoteDTO.getChange())//
                  .percentChange(quoteDTO.getPercentChange())//
                  .tradeVolume(quoteDTO.getTradeVolume())//
                  .highPriceOfTheDay(quoteDTO.getHighPriceOfTheDay())//
                  .lowPriceOfTheDay(quoteDTO.getLowPriceOfTheDay())//
                  .openPriceOfTheDay(quoteDTO.getOpenPriceOfTheDay())//
                  .previousClosePrice(quoteDTO.getPreviousClosePrice())//
                  .build();
  }

  public DataDto map(CompanyDTO companyDTO,QuoteDTO quoteDTO){
    return DataDto.builder()//
                  .symbol(companyDTO.getTicker())//
                  .name(companyDTO.getName())//
                  .industry(companyDTO.getFinnhubIndustry())//
                  .logo(companyDTO.getLogo())//
                  .marketCapitalization(companyDTO.getMarketCapitalization())//
                  .shareOutstanding(companyDTO.getShareOutstanding())//
                  .country(companyDTO.getCountry())//
                  .currency(companyDTO.getCurrency())//
                  .estimateCurrency(companyDTO.getEstimateCurrency())//
                  .exchange(companyDTO.getExchange())//
                  .ipo(companyDTO.getIpo())//
                  .phone(companyDTO.getPhone())//
                  .weburl(companyDTO.getWeburl())//
                  .currentPrice(quoteDTO.getCurrentPrice())//
                  .change(quoteDTO.getChange())//
                  .percentChange(quoteDTO.getPercentChange())//
                  .tradeVolume(quoteDTO.getTradeVolume())//
                  .build();

  }
}
