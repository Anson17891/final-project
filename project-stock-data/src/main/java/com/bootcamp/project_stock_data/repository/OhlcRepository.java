package com.bootcamp.project_stock_data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootcamp.project_stock_data.entity.OhlcEntity;


@Repository
public interface OhlcRepository extends JpaRepository<OhlcEntity, Long>{


//Run every day \/
//write new entity + save
//delete oldest entity , or may be not, easier :)

//!--------Keep in case------------
// @Query("select * from OhlcEntity s where s.tran_date = (select min(s2.tran_date) from OhlcEntity s2)")
// List<OhlcEntity> findOldestOhlcEntities();

// @Modifying  //ai: tell sb it is update/delete, not query
// @Transactional  //ai: prevent only part of data change, but not whole set of data
// @Query("delete from OhlcEntity s where s.tran_date = (select min (s2.tran_date) from OhlcEntity s2)")
// void deleteOldestRecord();
//!--------------------






//!connect to db(created by python:_2_xxx)
//@Query("select s from OhlcEntity s where s.symbol.symbol = :symbol order by s.tranDate desc")  //ai: Query by the symbol string field inside stockEntity
List<OhlcEntity> findAllBySymbol_SymbolOrderByTranDateDesc(@Param("symbol") String symbol);


}
