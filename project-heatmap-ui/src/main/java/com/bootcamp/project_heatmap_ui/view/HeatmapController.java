package com.bootcamp.project_heatmap_ui.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.project_heatmap_ui.dto.HeatmapDto;
import com.bootcamp.project_heatmap_ui.service.HeatmapService;

import tools.jackson.databind.ObjectMapper;

@Controller
public class HeatmapController {
    @Autowired
  private HeatmapService heatmapService;
  
@GetMapping("/data/heatmap")
public String getHeatmap (Model model){
  List<HeatmapDto> heatmapDtos = this.heatmapService.getHeatmap();
    ObjectMapper mapper = new ObjectMapper();
    String quotesJson = mapper.writeValueAsString(heatmapDtos);
    model.addAttribute("quotesJson", quotesJson);
    return "heatmap";
}

}
