package com.bootcamp.project_heatmap_ui.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bootcamp.project_heatmap_ui.dto.OhlcDto;
import com.bootcamp.project_heatmap_ui.model.OhlcDTO;
import com.bootcamp.project_heatmap_ui.model.ProfileDTO;

@Component
public class OhlcMapper {

    private OhlcDto.Ohlc mapOhlc(OhlcDTO ohlcDTO){
      return OhlcDto.Ohlc.ohlcBuilder()//
                    .tranDate(ohlcDTO.getTranDate())//
                    .open(ohlcDTO.getOpen())//
                    .high(ohlcDTO.getHigh())//
                    .low(ohlcDTO.getLow())//
                    .close(ohlcDTO.getClose())//
                    .volume(ohlcDTO.getVolume())//
                    .build();
    }


  public OhlcDto mapDto(ProfileDTO profileDTO, List<OhlcDTO> ohlcDTOs){

    List<OhlcDto.Ohlc> ohlcs = ohlcDTOs.stream()//
                                      .map(e->this.mapOhlc(e))//
                                      .toList();

    return OhlcDto.builder()//
                  .symbol(profileDTO.getSymbol())//
                  .name(profileDTO.getName())//
                  .marketCapitalization(profileDTO.getMarketCapitalization())//
                  .industry(profileDTO.getIndustry())//
                  .shareOutstanding((profileDTO.getShareOutstanding()))//
                  .logo(profileDTO.getLogo())//
                  .ohlcs(ohlcs)//
                  .build();
  }
}
