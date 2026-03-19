package com.bootcamp.project_data_provider.controller.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.project_data_provider.controller.DataOperator;
import com.bootcamp.project_data_provider.dto.CompanyDto;
import com.bootcamp.project_data_provider.dto.DataDto;
import com.bootcamp.project_data_provider.dto.QuoteDto;
import com.bootcamp.project_data_provider.managers.DtoMapper;
import com.bootcamp.project_data_provider.model.CompanyDTO;
import com.bootcamp.project_data_provider.model.QuoteDTO;
import com.bootcamp.project_data_provider.service.DataService;

@RestController
public class DataController implements DataOperator{
  @Autowired
  private DataService dataService;
  @Autowired
  private DtoMapper dtoMapper;

  @Override
  public CompanyDto getCompany(String symbol){
    CompanyDTO companyDTO = this.dataService.getCompany(symbol);
    return this.dtoMapper.mapCompany(companyDTO);

  }

  @Override
  public QuoteDto getQuote(String symbol){
    QuoteDTO quoteDTO = this.dataService.getQuote(symbol);
    return this.dtoMapper.mapQuote(quoteDTO,symbol);

  }


  @Override
  public DataDto getData(String symbol){
    QuoteDTO quoteDTO = this.dataService.getQuote(symbol);
    CompanyDTO companyDTO = this.dataService.getCompany(symbol);

    return this.dtoMapper.map(companyDTO,quoteDTO);
  }
}
