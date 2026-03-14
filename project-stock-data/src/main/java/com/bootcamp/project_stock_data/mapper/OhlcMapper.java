package com.bootcamp.project_stock_data.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.project_stock_data.entity.OhlcEntity;
import com.bootcamp.project_stock_data.model.OhlcDTO;


@Component
public class OhlcMapper {
  public OhlcDTO map(OhlcEntity ohlcEntity){
    return OhlcDTO.builder()//
                  .symbol(ohlcEntity.getSymbol().getSymbol())//
                  .open(ohlcEntity.getOpen())//
                  .close(ohlcEntity.getClose())//
                  .volume(ohlcEntity.getVolume())//
                  .low(ohlcEntity.getLow())//
                  .high(ohlcEntity.getHigh())//
                  .tran_date(ohlcEntity.getTran_date())//
                  .build();
  }
}
