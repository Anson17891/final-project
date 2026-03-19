package com.bootcamp.project_stock_data.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CompanyDTO {
private String country;
  private String currency;
  @JsonProperty("estimateCurrency")
  private String estimateCurrency;
  private String exchange;
  @JsonProperty("industry")
  private String industry;
  @JsonProperty("ipo")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate ipo;
  private String logo;
  @JsonProperty("marketCapitalization")
  private Double marketCapitalization;
  private String name;
  private String phone;
  private Double shareOutstanding;
  private String symbol;
  private String weburl;
}
