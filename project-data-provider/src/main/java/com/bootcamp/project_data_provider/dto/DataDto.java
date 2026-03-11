package com.bootcamp.project_data_provider.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

public class DataDto {
  private String symbol;
  private String name;
  private String industry;
  private String logo;
  private Double marketCapitalization;
  private Double share;
  private Double currentPrice;
  private Double change;
  private Double percentChange;
  private Long tradeVolume;


}
