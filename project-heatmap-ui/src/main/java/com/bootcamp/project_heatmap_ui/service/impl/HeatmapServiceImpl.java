package com.bootcamp.project_heatmap_ui.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.project_heatmap_ui.dto.HeatmapDto;
import com.bootcamp.project_heatmap_ui.mapper.HeatmapMapper;
import com.bootcamp.project_heatmap_ui.mapper.UrlManager;
import com.bootcamp.project_heatmap_ui.model.ProfileDTO;
import com.bootcamp.project_heatmap_ui.model.QuoteDTO;
import com.bootcamp.project_heatmap_ui.service.HeatmapService;
@Service
public class HeatmapServiceImpl implements HeatmapService{
  @Autowired
  private UrlManager urlManager;
  @Autowired
  private HeatmapMapper heatmapMapper;


  public List<HeatmapDto> getHeatmap(){

  List<HeatmapDto> heatmapDtos = new ArrayList<>();

  List<QuoteDTO> quotes = this.urlManager.getQuoteDTO();


  for(QuoteDTO q : quotes){
  ProfileDTO profile = this.urlManager.getProfileDTO(q.getSymbol());
  if (profile == null) {  //! there was null happened
        System.err.println("Profile not found for symbol: " + q.getSymbol());
        continue; 
    }

  heatmapDtos.add(this.heatmapMapper.map(q, profile));
  }
  return heatmapDtos;
  

  }
}
