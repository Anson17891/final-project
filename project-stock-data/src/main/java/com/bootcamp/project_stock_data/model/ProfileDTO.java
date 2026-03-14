package com.bootcamp.project_stock_data.model;

import java.time.LocalDate;

import lombok.Builder;

@Builder
public class ProfileDTO {
  private String country;
  private String estimateCurrency;
  private String exchange;
  private String industry;
  private String logo;
  private Double marketCapitalization;
  private String name;
  private Long phone;
  private Double shareOutstanding;
  private String symbol;
  private String weburl;
  private String currency;
  private LocalDate ipo;
}
