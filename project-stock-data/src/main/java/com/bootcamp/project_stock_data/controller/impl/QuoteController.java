package com.bootcamp.project_stock_data.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.project_stock_data.codeLib.RedisManager;
import com.bootcamp.project_stock_data.controller.QuoteOperator;
import com.bootcamp.project_stock_data.model.QuoteDTO;


@RestController
public class QuoteController implements QuoteOperator{
  @Autowired
  private RedisManager redisManager;
  
  @Override
  public List<QuoteDTO> getQuotes(){
    List<QuoteDTO> quotes = this.redisManager.getList("quotes:all",QuoteDTO.class);
    return quotes != null? quotes : List.of(); //!ai: prevent redis return null
  }
  
}
