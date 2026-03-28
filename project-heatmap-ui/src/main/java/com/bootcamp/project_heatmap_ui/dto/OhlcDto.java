package com.bootcamp.project_heatmap_ui.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OhlcDto {
  private String symbol;
  private String name;
  private Double marketCapitalization;
  private String industry;
  private Double shareOutstanding;
  private String logo;
  private String weburl;
  private List<Ohlc> ohlcs;

@Data
@AllArgsConstructor
@NoArgsConstructor
  public static class Ohlc{
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate tranDate;
    private Double open;
    private Double high;
    private Double low;
    private Double close;
    private Long volume;

    public static OhlcBuilder ohlcBuilder() {
         return new OhlcBuilder();
      }
      public static class OhlcBuilder {
         private LocalDate tranDate;
         private Double open;
         private Double high;
         private Double low;
         private Double close;
         private Long volume;
         OhlcBuilder() {
         }
         @JsonFormat(
            pattern = "yyyy-MM-dd"
         )
         public OhlcBuilder tranDate(final LocalDate tranDate) {
            this.tranDate = tranDate;
            return this;
         }
         public OhlcBuilder open(final Double open) {
            this.open = open;
            return this;
         }
         public OhlcBuilder high(final Double high) {
            this.high = high;
            return this;
         }
         public OhlcBuilder low(final Double low) {
            this.low = low;
            return this;
         }
         public OhlcBuilder close(final Double close) {
            this.close = close;
            return this;
         }
         public OhlcBuilder volume(final Long volume) {
            this.volume = volume;
            return this;
         }
         public Ohlc build() {
            return new Ohlc(this.tranDate, this.open, this.high, this.low, this.close, this.volume);
         }
      }
  }
  public static OhlcDtoBuilder builder() {
      return new OhlcDtoBuilder();
   }
    public static class OhlcDtoBuilder {
      private String symbol;
      private String name;
      private Double marketCapitalization;
      private String industry;
      private Double shareOutstanding;
      private String logo;
      private String weburl;
      private List<Ohlc> ohlcs;
      OhlcDtoBuilder() {
      }
      public OhlcDtoBuilder symbol(final String symbol) {
         this.symbol = symbol;
         return this;
      }
      public OhlcDtoBuilder name(final String name) {
         this.name = name;
         return this;
      }
      public OhlcDtoBuilder marketCapitalization(final Double marketCapitalization) {
         this.marketCapitalization = marketCapitalization;
         return this;
      }
      public OhlcDtoBuilder industry(final String industry) {
         this.industry = industry;
         return this;
      }
      public OhlcDtoBuilder shareOutstanding(final Double shareOutstanding) {
         this.shareOutstanding = shareOutstanding;
         return this;
      }
      public OhlcDtoBuilder logo(final String logo) {
         this.logo = logo;
         return this;
      }
      public OhlcDtoBuilder ohlcs(final List<Ohlc> ohlcs) {
         this.ohlcs = ohlcs;
         return this;
      }
      public OhlcDtoBuilder weburl(final String weburl){
         this.weburl = weburl;
         return this;
      }
      public OhlcDto build() {
         return new OhlcDto(this.symbol, this.name, this.marketCapitalization, this.industry, this.shareOutstanding, this.logo,this.weburl, this.ohlcs);
      }
   }




}
