package com.bootcamp.project_data_provider.managers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class UrlManager {
  @Value("${finnhub.data.domain}")
  private String domain;
  @Value("${finnhub.data.path}")
  private String path;
  @Value("${finnhub.data.query.token}")
  private String token;

  public String generateUrl(String dataType, String symbol){
    String url = UriComponentsBuilder.newInstance()//
    .scheme("https")//
    .host(domain)//
    .path(path)//
    .path(dataType)//
    .queryParam("symbol", symbol)//
    .queryParam("token", token)//
    .build()//
    .toUriString();
    return url;
  }
}
