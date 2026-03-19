package com.bootcamp.project_data_provider.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QuoteDto {
  private String symbol;
  private Double currentPrice;
  private Double change;
  private Double percentChange;
  private Long tradeVolume;
  private Double highPriceOfTheDay;
  private Double lowPriceOfTheDay;
  private Double openPriceOfTheDay;
  private Double previousClosePrice;
}
