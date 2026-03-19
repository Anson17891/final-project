package com.bootcamp.project_data_provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.project_data_provider.managers.UrlManager;
import com.bootcamp.project_data_provider.model.CompanyDTO;
import com.bootcamp.project_data_provider.model.QuoteDTO;
import com.bootcamp.project_data_provider.service.DataService;

@Service
public class DataServiceImpl implements DataService{
  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private UrlManager urlManager;

  @Value("${finnhub.data.quote}")
  private String quote;
  @Value("${finnhub.data.profile}")
  private String profile;

  @Override
  public QuoteDTO getQuote(String symbol){
    String url = urlManager.generateUrl(quote, symbol);
    QuoteDTO quoteDTO = this.restTemplate.getForObject(url, QuoteDTO.class);
    //! in case the url doesn't work -> other source?

    return quoteDTO;
  }

  @Override
  public CompanyDTO getCompany(String symbol){
    String url = urlManager.generateUrl(profile, symbol);
    CompanyDTO companyDTO = this.restTemplate.getForObject(url, CompanyDTO.class);
    return companyDTO;
  }
}


