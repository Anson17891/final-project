package com.bootcamp.project_stock_data.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.project_stock_data.model.OhlcDTO;

public interface OhlcOperator {
  @GetMapping("ohlcs")
  List<OhlcDTO> getOhlcsBySymbol(@RequestParam String symbol); 
}
