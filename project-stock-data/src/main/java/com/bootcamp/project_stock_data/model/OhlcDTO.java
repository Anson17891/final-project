package com.bootcamp.project_stock_data.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class OhlcDTO {
  // @JsonProperty("tran_date")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate tranDate;
  private String symbol;
  private Double open;
  private Double close;
  private Long volume;
  private Double low;
  private Double high;
}
