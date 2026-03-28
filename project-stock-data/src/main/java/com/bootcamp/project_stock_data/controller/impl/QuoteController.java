package com.bootcamp.project_stock_data.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.project_stock_data.controller.QuoteOperator;
import com.bootcamp.project_stock_data.mapper.QuoteMapper;
import com.bootcamp.project_stock_data.model.QuoteDTO;
import com.bootcamp.project_stock_data.service.QuoteService;

import jakarta.persistence.NonUniqueResultException;


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
    List<QuoteDTO> quotes = new ArrayList<>();
    try{ 
        quotes.addAll(this.quoteService.findAll().stream()//
                                      .map(e -> this.quoteMapper.mapToDTO(e))//
                                      .toList());
                                        return quotes;
                                    }catch (NonUniqueResultException e) {
            System.out.println("Multiple results found.");}
return quotes;
    

  }
  
}
