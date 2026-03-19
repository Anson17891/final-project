package com.bootcamp.project_stock_data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "quote_table")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuoteEntity {
  @Id
  // @GeneratedValue(strategy=GenerationType.IDENTITY)
  // private Long id;
    private String symbol;
  @Column(name="current_price", nullable=false)
  private Double currentPrice;
    @Column(name="price_change", nullable=false)
  private Double change;
    @Column(name="percent_change", nullable=false)
  private Double percentChange;
    @Column(name="trade_volume", nullable=false)
  private Long tradeVolume;
    @Column(name="high_price_of_the_day", nullable=false)
  private Double highPriceOfTheDay;
    @Column(name="low_price_of_the_day", nullable=false)
  private Double lowPriceOfTheDay;
    @Column(name="open_price_of_the_day", nullable=false)
  private Double openPriceOfTheDay;
    @Column(name="previous_close_price", nullable=false)
  private Double previousClosePrice;

}
