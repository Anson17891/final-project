package com.bootcamp.project_stock_data.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class ProfileDto {
  private String country;
  private String estimateCurrency;
  private String exchange;
  private String industry;
  private String logo;
  private Double marketCapitalization;
  private String name;
  private String phone;
  private Double shareOutstanding;
  private String symbol;
  private String weburl;
  private String currency;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate ipo;
}
