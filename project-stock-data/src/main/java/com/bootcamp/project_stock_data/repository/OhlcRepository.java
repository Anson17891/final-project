package com.bootcamp.project_stock_data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootcamp.project_stock_data.entity.OhlcEntity;


@Repository
public interface OhlcRepository extends JpaRepository<OhlcEntity, Long>{

//List<OhlcEntity> findAll

//Run every day \/
//write new entity + save
//delete oldest entity  (print what is deleted would be better?)


//!connect to db(created by python:_2_xxx)
@Query("select s from OhlcEntity s where s.symbol.symbol = :symbol")  //ai: Query by the symbol string field inside stockEntity
List<OhlcEntity> findBySymbol(@Param("symbol") String symbol);


}
