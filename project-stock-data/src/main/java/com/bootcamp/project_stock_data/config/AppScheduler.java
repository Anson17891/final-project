package com.bootcamp.project_stock_data.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AppScheduler {
  @Scheduled(cron = "0 6 20 * * MON-FRI", zone = "Asia/Hong_Kong")
 public void runTask(){
  System.out.println("Testing");
 }
}
