package com.bootcamp.project_heatmap_ui.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
  @Bean
    RestTemplate restTemplate(){
    return new RestTemplate();
  }
  
}
