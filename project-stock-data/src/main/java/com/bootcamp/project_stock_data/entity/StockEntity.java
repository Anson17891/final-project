package com.bootcamp.project_stock_data.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="symbols")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class StockEntity {
  @Id
  private String symbol;
  @Column(name = "company")
  private String company;
  @Column(name = "sector")
  private String sector;
  @Column(name = "industry")
  private String industry;
  @Column(name = "headquarters_location")
  private String headquartersLocation;
  @Column(name = "date_added")
  private LocalDate dateAdded;
  @Column(name = "cik")
  private Long cik;
  @Column(name = "founded")
  private String founded;


}
