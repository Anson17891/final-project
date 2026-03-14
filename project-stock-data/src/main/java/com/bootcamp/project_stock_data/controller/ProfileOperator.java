package com.bootcamp.project_stock_data.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.project_stock_data.model.ProfileDTO;


public interface ProfileOperator {
  @GetMapping("profile")
  ProfileDTO getProfile(@RequestParam String symbol);
}
