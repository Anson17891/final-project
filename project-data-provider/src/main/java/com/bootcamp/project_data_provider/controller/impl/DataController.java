package com.bootcamp.project_data_provider.controller.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.project_data_provider.controller.DataOperator;
import com.bootcamp.project_data_provider.dto.DataDto;
import com.bootcamp.project_data_provider.managers.DtoMapper;
import com.bootcamp.project_data_provider.model.CompanyDTO;
import com.bootcamp.project_data_provider.model.StockDTO;
import com.bootcamp.project_data_provider.service.DataService;

@RestController
public class DataController implements DataOperator{
  @Autowired
  private DataService dataService;
  @Autowired
  private DtoMapper dtoMapper;

  @Override
  public DataDto getStockData(String symbol){
    StockDTO stockDTO = this.dataService.getStock(symbol);
    CompanyDTO companyDTO = this.dataService.getCompany(symbol);

    DataDto dataDto = this.dtoMapper.map(companyDTO, stockDTO);

    return dataDto;
  }
}
