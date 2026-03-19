package com.bootcamp.project_heatmap_ui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuoteDTO {
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
