package com.bootcamp.project_heatmap_ui.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.project_heatmap_ui.controller.OhlcOperator;
import com.bootcamp.project_heatmap_ui.dto.OhlcDto;
import com.bootcamp.project_heatmap_ui.service.OhlcService;
@RestController
public class OhlcController implements OhlcOperator{
@Autowired
private OhlcService ohlcService;

@Override
  public OhlcDto getOhlc(@RequestParam String symbol){
    return this.ohlcService.getOhlc(symbol);
  }
  
}
