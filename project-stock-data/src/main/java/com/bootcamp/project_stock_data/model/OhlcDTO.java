package com.bootcamp.project_stock_data.model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OhlcDTO {
  private LocalDate tran_date;
  private String symbol;
  private Double open;
  private Double close;
  private Long volume;
  private Double low;
  private Double high;
}
