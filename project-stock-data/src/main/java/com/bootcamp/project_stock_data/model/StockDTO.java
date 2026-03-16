package com.bootcamp.project_stock_data.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class StockDTO {
  private String symbol;
  private String company;
  private String sector;
  private String industry;
  private String headquartersLocation;
  private LocalDate dateAdded;
  private Long cik;
  private String founded;
}
