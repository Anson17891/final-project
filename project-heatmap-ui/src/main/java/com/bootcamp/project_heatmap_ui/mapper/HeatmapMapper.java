package com.bootcamp.project_heatmap_ui.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.project_heatmap_ui.dto.HeatmapDto;
import com.bootcamp.project_heatmap_ui.model.ProfileDTO;
import com.bootcamp.project_heatmap_ui.model.QuoteDTO;

@Component
public class HeatmapMapper {
  public HeatmapDto map(QuoteDTO quoteDTO, ProfileDTO profileDTO){
    return HeatmapDto.builder()//
                      .symbol(profileDTO.getSymbol())//
                      .name(profileDTO.getName())//
                      .marketCapitalization(profileDTO.getMarketCapitalization())//
                      .industry(profileDTO.getIndustry())//
                      .ipo(profileDTO.getIpo())//
                      .webUrl(profileDTO.getWeburl())//
                      .shareOutstanding(profileDTO.getShareOutstanding())//
                      .logo(profileDTO.getLogo())//
                      .price(quoteDTO.getCurrentPrice())//
                      .priceChange(quoteDTO.getChange())//
                      .percentChange(quoteDTO.getPercentChange())//
                      .build();
  }
}
