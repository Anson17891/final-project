package com.bootcamp.project_data_provider.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DataDto {
  private String country;
  private String currency;
  private String estimateCurrency;
  private String exchange;
  private String industry;
  private LocalDate ipo;
  private String logo;
  private Double marketCapitalization;
  private String name;
  private String phone;
  private Double shareOutstanding;
  private String weburl;
  private String symbol;
  private Double currentPrice;
  private Double change;
  private Double percentChange;
  private Long tradeVolume;
}
