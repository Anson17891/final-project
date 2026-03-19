package com.bootcamp.project_data_provider.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class CompanyDto {
  private String symbol;
  private String name;
  private String industry;
  private String logo;
  private Double marketCapitalization;
  private String country;
  private String currency;
  private String estimateCurrency;
  private String exchange;
  private LocalDate ipo;
  private String phone;
  private Double shareOutstanding;
  private String weburl;



}
