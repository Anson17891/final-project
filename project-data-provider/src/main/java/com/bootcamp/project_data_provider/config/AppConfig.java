package com.bootcamp.project_data_provider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.client.RestTemplate;

import tools.jackson.databind.ObjectMapper;



@Configuration
public class AppConfig {
  @Bean
    RestTemplate restTemplate(){
    return new RestTemplate();
  }




}
