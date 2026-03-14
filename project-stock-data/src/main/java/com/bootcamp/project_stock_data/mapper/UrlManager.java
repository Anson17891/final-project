package com.bootcamp.project_stock_data.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bootcamp.project_stock_data.model.CompanyDTO;
import com.bootcamp.project_stock_data.model.QuoteDTO;

@Component
public class UrlManager {
    @Value("${app.provider.base-url}")
    private String baseUrl;

    @Value("${app.provider.datatype.profile}")
    private String profilePath;

    @Value("${app.provider.datatype.quote}")
    private String quotePath;

    @Autowired
    private RestTemplate restTemplate;

  public <T> T getDTO(String symbol, String path, Class<T> clazz){
  String url = UriComponentsBuilder//
    .fromUriString(baseUrl)//
    .pathSegment(path)//
    .queryParam("symbol", symbol)
    .toUriString();
try{
return this.restTemplate.getForObject(url, clazz);
}catch (RestClientException e){System.err.println("Error fetching profile for " + symbol + ": " + e.getMessage());
        return null;
    }
}


  public CompanyDTO getCompanyDTO(String symbol){
    return this.getDTO(symbol, profilePath, CompanyDTO.class);
  }

  public QuoteDTO getQuoteDTO(String symbol){
    return this.getDTO(symbol, quotePath, QuoteDTO.class);
  }
}
