package com.bootcamp.project_heatmap_ui.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.project_heatmap_ui.dto.HeatmapDto;

public interface HeatmapJsonOperator {
  @GetMapping("/json/heatmap")
  List<HeatmapDto> getHeatmap ();
}
