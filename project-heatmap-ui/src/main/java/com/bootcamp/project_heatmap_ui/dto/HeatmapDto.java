package com.bootcamp.project_heatmap_ui.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeatmapDto {
  private String symbol;
  private String name;
  private Double price;
  private Double priceChange;
  private Double percentChange;
  private Double marketCapitalization;
  private String industry;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate ipo;
  private String webUrl;
  private Double shareOutstanding;
  private String logo;

  public static HeatmapDtoBuilder builder() {
      return new HeatmapDtoBuilder();
   }
   public static class HeatmapDtoBuilder {
      private String symbol;
      private String name;
      private Double price;
      private Double priceChange;
      private Double percentChange;
      private Double marketCapitalization;
      private String industry;
      private LocalDate ipo;
      private String webUrl;
      private Double shareOutstanding;
      private String logo;
      HeatmapDtoBuilder() {
      }
      public HeatmapDtoBuilder symbol(final String symbol) {
         this.symbol = symbol;
         return this;
      }
      public HeatmapDtoBuilder name(final String name) {
         this.name = name;
         return this;
      }
            public HeatmapDtoBuilder price(final Double price) {
         this.price = price;
         return this;
      }
      public HeatmapDtoBuilder priceChange(final Double priceChange) {
         this.priceChange = priceChange;
         return this;
      }
      public HeatmapDtoBuilder percentChange(final Double percentChange) {
         this.percentChange = percentChange;
         return this;
      }
      public HeatmapDtoBuilder marketCapitalization(final Double marketCapitalization) {
         this.marketCapitalization = marketCapitalization;
         return this;
      }
      public HeatmapDtoBuilder industry(final String industry) {
         this.industry = industry;
         return this;
      }
      @JsonFormat(
         pattern = "yyyy-MM-dd"
      )
      public HeatmapDtoBuilder ipo(final LocalDate ipo) {
         this.ipo = ipo;
         return this;
      }
      public HeatmapDtoBuilder webUrl(final String webUrl) {
         this.webUrl = webUrl;
         return this;
      }
      public HeatmapDtoBuilder shareOutstanding(final Double shareOutstanding) {
         this.shareOutstanding = shareOutstanding;
         return this;
      }
      public HeatmapDtoBuilder logo(final String logo) {
         this.logo = logo;
         return this;
      }
      public HeatmapDto build() {
         return new HeatmapDto(this.symbol, this.name, this.price, this.priceChange, this.percentChange, this.marketCapitalization, this.industry, this.ipo, this.webUrl, this.shareOutstanding, this.logo);
      }
   }
}
