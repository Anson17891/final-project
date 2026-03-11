package com.bootcamp.project_data_provider.service;

import com.bootcamp.project_data_provider.model.CompanyDTO;
import com.bootcamp.project_data_provider.model.StockDTO;

public interface DataService {
  StockDTO getStock(String symbol);
  CompanyDTO getCompany(String symbol);
}
