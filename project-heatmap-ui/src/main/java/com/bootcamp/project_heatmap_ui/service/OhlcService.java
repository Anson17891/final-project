package com.bootcamp.project_heatmap_ui.service;

import com.bootcamp.project_heatmap_ui.dto.OhlcDto;

public interface OhlcService {
    OhlcDto getOhlc(String symbol);
}
