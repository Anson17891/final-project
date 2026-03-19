package com.bootcamp.project_data_provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.project_data_provider.dto.CompanyDto;
import com.bootcamp.project_data_provider.dto.DataDto;
import com.bootcamp.project_data_provider.dto.QuoteDto;
// import com.bootcamp.project_data_provider.model.CompanyDTO;
// import com.bootcamp.project_data_provider.model.QuoteDTO;



public interface DataOperator {
  @GetMapping(value = "/company")
  CompanyDto getCompany(@RequestParam String symbol);

  @GetMapping(value = "/quote")
  QuoteDto getQuote(@RequestParam String symbol);
  
  @GetMapping(value = "/data")
  DataDto getData(@RequestParam String symbol);
  
}

