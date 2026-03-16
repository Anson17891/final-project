package com.bootcamp.project_stock_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.project_stock_data.entity.QuoteEntity;

public interface QuoteRepository extends JpaRepository<QuoteEntity, Long>{


  
}
