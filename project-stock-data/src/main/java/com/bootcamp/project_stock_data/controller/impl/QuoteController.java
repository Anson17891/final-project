package com.bootcamp.project_stock_data.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.project_stock_data.controller.QuoteOperator;
import com.bootcamp.project_stock_data.mapper.QuoteMapper;
import com.bootcamp.project_stock_data.model.QuoteDTO;
import com.bootcamp.project_stock_data.service.QuoteService;


@RestController
public class QuoteController implements QuoteOperator{
  // @Autowired
  // private RedisManager redisManager;
  @Autowired
  private QuoteService quoteService;
  @Autowired
  private QuoteMapper quoteMapper;
  
  @Override
  public List<QuoteDTO> getQuotes(){
    return this.quoteService.findAll().stream()//
                                      .map(e -> this.quoteMapper.mapToDTO(e))//
                                      .toList();

  }
  
}
