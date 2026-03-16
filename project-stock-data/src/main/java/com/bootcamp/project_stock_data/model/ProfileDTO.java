package com.bootcamp.project_stock_data.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class ProfileDTO {
  private String country;
    @JsonProperty("estimate_currency")
  private String estimateCurrency;
  private String exchange;
  private String industry;
  private String logo;
    @JsonProperty("market_capitalization")
  private Double marketCapitalization;
  private String name;
  private String phone;
    @JsonProperty("share_outstanding")
  private Double shareOutstanding;
  private String symbol;
  private String weburl;
  private String currency;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate ipo;
}
