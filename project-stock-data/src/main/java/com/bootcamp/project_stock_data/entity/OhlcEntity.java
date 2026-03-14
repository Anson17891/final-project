package com.bootcamp.project_stock_data.entity;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stock_ohlc_data")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OhlcEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // surrogate PK
  private Long id;

  @Column(name = "tran_date", nullable=false)
  private LocalDate tran_date;
  @Column(nullable=false)
  private Double close;
  @Column(nullable=false)
  private Double low;
  @Column(nullable=false)
  private Double open;
  @Column(nullable=false)
  private Long volume;
  @Column(nullable=false)
  private Double high;

  @ManyToOne
  @JoinColumn(name="symbol",nullable=false)
  private StockEntity symbol;
}
