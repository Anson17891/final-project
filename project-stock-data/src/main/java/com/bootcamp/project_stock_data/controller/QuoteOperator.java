package com.bootcamp.project_stock_data.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.project_stock_data.model.QuoteDTO;

public interface QuoteOperator {
  @GetMapping("/quotes")
  List<QuoteDTO> getQuotes();
}
