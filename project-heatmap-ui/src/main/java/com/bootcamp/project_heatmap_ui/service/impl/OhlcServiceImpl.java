package com.bootcamp.project_heatmap_ui.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.project_heatmap_ui.dto.OhlcDto;
import com.bootcamp.project_heatmap_ui.mapper.OhlcMapper;
import com.bootcamp.project_heatmap_ui.mapper.UrlManager;
import com.bootcamp.project_heatmap_ui.model.OhlcDTO;
import com.bootcamp.project_heatmap_ui.model.ProfileDTO;
import com.bootcamp.project_heatmap_ui.service.OhlcService;

@Service
public class OhlcServiceImpl implements OhlcService{
  @Autowired
  private UrlManager urlManager;
  @Autowired
  private OhlcMapper ohlcMapper;
  

  @Override
  public OhlcDto getOhlc(String symbol){
    List<OhlcDTO> ohlcDTOs = this.urlManager.getOhlcDTO(symbol);
    ProfileDTO profileDTO = this.urlManager.getProfileDTO(symbol);
    return this.ohlcMapper.mapDto(profileDTO, ohlcDTOs);

  }
}
