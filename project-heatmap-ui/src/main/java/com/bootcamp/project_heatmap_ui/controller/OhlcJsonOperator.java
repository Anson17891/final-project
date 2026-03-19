package com.bootcamp.project_heatmap_ui.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.project_heatmap_ui.dto.OhlcDto;


public interface OhlcJsonOperator {
  @GetMapping("/json/ohlc")
  OhlcDto getOhlc(@RequestParam String symbol);
  
}
