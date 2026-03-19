package com.bootcamp.project_stock_data.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.project_stock_data.entity.QuoteEntity;
import com.bootcamp.project_stock_data.model.QuoteDTO;

@Component
public class QuoteMapper {
  public QuoteEntity mapToEntity(QuoteDTO quoteDTO){
    return QuoteEntity.builder()//
                      .symbol(quoteDTO.getSymbol())//
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

  public QuoteDTO mapToDTO(QuoteEntity quoteEntity){
    return QuoteDTO.builder()//
                      .symbol(quoteEntity.getSymbol())//
                      .currentPrice(quoteEntity.getCurrentPrice())//
                      .change(quoteEntity.getChange())//
                      .percentChange(quoteEntity.getPercentChange())//
                      .tradeVolume(quoteEntity.getTradeVolume())//
                      .highPriceOfTheDay(quoteEntity.getHighPriceOfTheDay())//
                      .lowPriceOfTheDay(quoteEntity.getLowPriceOfTheDay())//
                      .openPriceOfTheDay(quoteEntity.getOpenPriceOfTheDay())//
                      .previousClosePrice(quoteEntity.getPreviousClosePrice())//
                      .build();
  }

}
