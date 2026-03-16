package com.bootcamp.project_stock_data.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.project_stock_data.controller.OhlcOperator;
import com.bootcamp.project_stock_data.entity.OhlcEntity;
import com.bootcamp.project_stock_data.mapper.OhlcMapper;
import com.bootcamp.project_stock_data.model.OhlcDTO;
import com.bootcamp.project_stock_data.service.OhlcService;

@RestController
public class OhlcController implements OhlcOperator{
  @Autowired
  private OhlcService ohlcService;
  @Autowired
  private OhlcMapper ohlcMapper;

  @Override
  public List<OhlcDTO> getOhlcsBySymbol(String symbol){  //! follow work: check wheather symbol exist
    List<OhlcDTO> ohlcs = new ArrayList<>();
    List<OhlcEntity> ohlcEntities = this.ohlcService.getOhlcsBySymbol(symbol);
    if(ohlcEntities == null||ohlcEntities.isEmpty()){
      throw(new IllegalArgumentException("Symbol not found:" + symbol));
    }
    for(OhlcEntity e : ohlcEntities){
      ohlcs.add(this.ohlcMapper.map(e));
    }
    return ohlcs;
  }

  
}
