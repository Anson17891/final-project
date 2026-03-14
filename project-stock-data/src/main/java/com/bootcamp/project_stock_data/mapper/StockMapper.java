package com.bootcamp.project_stock_data.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.project_stock_data.entity.StockEntity;
import com.bootcamp.project_stock_data.model.StockDTO;


@Component
public class StockMapper {


    public StockDTO map(StockEntity stockEntity){
      return StockDTO.builder()//
                     .symbol(stockEntity.getSymbol())//
                     .company(stockEntity.getCompany())//
                     .sector(stockEntity.getSector())//
                     .industry(stockEntity.getIndustry())//
                     .headquartersLocation(stockEntity.getHeadquartersLocation())//
                     .dateAdded(stockEntity.getDateAdded())//
                     .cik(stockEntity.getCik())//
                     .founded(stockEntity.getFounded())//
                     .build();
    }
}
