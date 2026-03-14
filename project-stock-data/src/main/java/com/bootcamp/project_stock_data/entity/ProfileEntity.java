package com.bootcamp.project_stock_data.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Profile_table")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ProfileEntity {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  @Column(nullable=false)
  private String name;
  private String logo;
  private String symbol;
  private Double marketCapitalization;
  private Double shareOutstanding;
  @Column(name="industry", nullable=false)
  private String finnhubIndustry;
  private String weburl;
  private String country;
  private Long phone;
  private String estimateCurrency;
  private String exchange;
  private String currency;
  private LocalDate ipo;
  @OneToOne
  @JoinTable(name = "stock_symbol")
  private StockEntity stockEntity;
}
