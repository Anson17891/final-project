package com.bootcamp.project_stock_data.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class CompanyDTO {
private String country;
  private String currency;
  @JsonProperty("estimate_currency")
  private String estimateCurrency;
  private String exchange;
  @JsonProperty("market_capitalization")
  private String finnhubIndustry;
  private LocalDate ipo;
  private String logo;
  @JsonProperty("market_capitalization")
  private Double marketCapitalization;
  private String name;
  private String phone;
  private Double shareOutstanding;
  private String ticker;
  private String weburl;
}
