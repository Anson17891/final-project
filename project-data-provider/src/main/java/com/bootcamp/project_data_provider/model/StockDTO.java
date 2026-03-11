package com.bootcamp.project_data_provider.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class StockDTO {
  @JsonProperty("c")
    private Double currentPrice;

  @JsonProperty("d")
  private Double change;

  @JsonProperty("dp")
  private Double percentChange;

  @JsonProperty("h")
  private Double highPriceOfTheDay;

  @JsonProperty("l")
  private Double lowPriceOfTheDay;

  @JsonProperty("o")
  private Double openPriceOfTheDay;

  @JsonProperty("pc")
  private Double previousClosePrice;

  @JsonProperty("t")
  private Long tradeVolume;
}
