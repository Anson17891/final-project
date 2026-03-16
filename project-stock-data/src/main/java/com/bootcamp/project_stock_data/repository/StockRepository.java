package com.bootcamp.project_stock_data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bootcamp.project_stock_data.entity.StockEntity;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, String>{

@Query("select s.symbol from StockEntity s")
  List<String> findAllSymbols();


  Optional<StockEntity> findBySymbol(String symbol);

}
