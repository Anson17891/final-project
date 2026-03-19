package com.bootcamp.project_heatmap_ui.mapper;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bootcamp.project_heatmap_ui.model.OhlcDTO;
import com.bootcamp.project_heatmap_ui.model.ProfileDTO;
import com.bootcamp.project_heatmap_ui.model.QuoteDTO;
import com.bootcamp.project_heatmap_ui.model.StockDTO;



@Component
public class UrlManager {
    @Value("${stock-data.domain}")
    private String domain;

    @Value("${stock-data.datatype.ohlcs}")
    private String ohlcPath;

    @Value("${stock-data.datatype.quotes}")
    private String quotePath;

    @Value("${stock-data.datatype.stock}")
    private String stockPath;

    @Value("${stock-data.datatype.profile}")
    private String profilePath;

    @Autowired
    private RestTemplate restTemplate;

  public <T> T getDTO(String symbol, String path, Class<T> clazz){
  String url = UriComponentsBuilder//
    .fromUriString(domain)//
    .pathSegment(path)//
    .queryParam("symbol", symbol)
    .toUriString();
try{
return this.restTemplate.getForObject(url, clazz);
}catch (RestClientException e){System.err.println("Error fetching for " + symbol + ": " + e.getMessage());
        return null;
    }
}


    public List<OhlcDTO> getOhlcDTO(String symbol) {
        String url = UriComponentsBuilder
            .fromUriString(domain)
            .pathSegment(ohlcPath)
            .queryParam("symbol", symbol)
            .toUriString();
        try {
            ResponseEntity<List<OhlcDTO>> response = restTemplate.exchange(    //!ResponseEntity + exchange +ParameterizedTypeReference <-search it!!!!
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<OhlcDTO>>() {}
            );
            return response.getBody();
        } catch (RestClientException e) {
            System.err.println("Error fetching OhlcDTO for " + symbol + ": " + e.getMessage());
            return List.of();
        }
    }


    public ProfileDTO getProfileDTO(String symbol){
    ProfileDTO profile = this.getDTO(symbol, profilePath, ProfileDTO.class);
    if (profile == null) {
        System.err.println("ProfileDTO is null for symbol: " + symbol);
    }
    return profile;
}


    public StockDTO getStockDTO(String symbol){
    return this.getDTO(symbol, stockPath, StockDTO.class);
  }



public List<QuoteDTO> getQuoteDTO() {
        String url = UriComponentsBuilder
            .fromUriString(domain)
            .pathSegment(quotePath)
            .toUriString();
        try {
            ResponseEntity<List<QuoteDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<QuoteDTO>>() {}
            );
            return response.getBody();
        } catch (RestClientException e) {
            System.err.println("Error fetching QuoteDTO: " + e.getMessage());
            return List.of();
        }
    }
}


