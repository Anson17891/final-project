package com.bootcamp.project_data_provider.service;

import com.bootcamp.project_data_provider.model.CompanyDTO;
import com.bootcamp.project_data_provider.model.QuoteDTO;

public interface DataService {
  QuoteDTO getQuote(String symbol);
  CompanyDTO getCompany(String symbol);
}
