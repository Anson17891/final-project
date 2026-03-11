package com.bootcamp.project_data_provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.project_data_provider.dto.DataDto;

public interface DataOperator {
  @GetMapping(value = "/stock")
  DataDto getStockData(@RequestParam String symbol);


}
