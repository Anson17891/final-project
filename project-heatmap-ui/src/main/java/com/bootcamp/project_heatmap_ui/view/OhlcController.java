package com.bootcamp.project_heatmap_ui.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.project_heatmap_ui.dto.OhlcDto;
import com.bootcamp.project_heatmap_ui.service.OhlcService;

import tools.jackson.databind.ObjectMapper;


@Controller
public class OhlcController {
  @Autowired
  private OhlcService ohlcService;
   
  @GetMapping("/data/ohlc")
  public String getOhlc(@RequestParam String symbol, Model model) {
    OhlcDto ohlcDto = this.ohlcService.getOhlc(symbol);
    ObjectMapper mapper = new ObjectMapper();
    String ohlcJson = mapper.writeValueAsString(ohlcDto);
    model.addAttribute("ohlcJson", ohlcJson);
      return "candlestick";
  }
  
}
