package com.bootcamp.project_data_provider.model;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class CompanyDTO {
    private String country;
  private String currency;
  private String estimateCurrency;
  private String exchange;
  private String finnhubIndustry;
  private LocalDate ipo;
  private String logo;
  private Double marketCapitalization;
  private String name;
  private Long phone;
  private Double shareOutstanding;
  private String ticker;
  private String weburl;
}
