package com.bootcamp.project_heatmap_ui.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.project_heatmap_ui.controller.HeatmapJsonOperator;
import com.bootcamp.project_heatmap_ui.dto.HeatmapDto;
import com.bootcamp.project_heatmap_ui.service.HeatmapService;

@RestController
public class HeatmapJsonController implements HeatmapJsonOperator{
  @Autowired
  private HeatmapService heatmapService;
  
@Override
public List<HeatmapDto> getHeatmap (){
  return this.heatmapService.getHeatmap();
}  
}
