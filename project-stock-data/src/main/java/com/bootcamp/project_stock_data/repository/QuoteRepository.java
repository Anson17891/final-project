package com.bootcamp.project_stock_data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.project_stock_data.entity.QuoteEntity;

@Repository
public interface QuoteRepository extends JpaRepository<QuoteEntity, String>{


    public List<QuoteEntity> findAllBySymbolIn(List<String> missingSymbols);
    public Optional<QuoteEntity> findFirstBySymbol(String symbol);


  
}
