package com.bootcamp.project_stock_data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.project_stock_data.entity.ProfileEntity;


@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, Long>{
  Optional<ProfileEntity> findBySymbol(String symbol);
}
