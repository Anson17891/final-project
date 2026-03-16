package com.bootcamp.project_stock_data.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "profile_table")
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
  @Column(name = "market_capitalization")
  private Double marketCapitalization;
  @Column(name = "share_outstanding")
  private Double shareOutstanding;
  @Column(name="industry", nullable=false)
  private String industry;
  private String weburl;
  private String country;
  private String phone;
  @Column(name = "estimate_currency")
  private String estimateCurrency;
  private String exchange;
  private String currency;
  private LocalDate ipo;
  @OneToOne
@JoinColumn(name = "stock_id", referencedColumnName = "id")
  private StockEntity stockEntity;
}
