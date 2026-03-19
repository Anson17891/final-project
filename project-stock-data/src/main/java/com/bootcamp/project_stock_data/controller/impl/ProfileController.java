package com.bootcamp.project_stock_data.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.project_stock_data.controller.ProfileOperator;
import com.bootcamp.project_stock_data.dto.ProfileDto;
import com.bootcamp.project_stock_data.entity.ProfileEntity;
import com.bootcamp.project_stock_data.mapper.ProfileMapper;
import com.bootcamp.project_stock_data.model.ProfileDTO;
import com.bootcamp.project_stock_data.service.ProfileService;

@RestController
public class ProfileController implements ProfileOperator{
@Autowired
private ProfileService profileService;
@Autowired
private ProfileMapper profileMapper;


// @Override
//   public ProfileDTO getProfile(String symbol){
//   ProfileEntity profileEntity = this.profileService.getProfileEntity(symbol);
//   return this.profileMapper.map(profileEntity);
//   }

@Override
public ResponseEntity<ProfileDto> getProfile(String symbol) {
    ProfileEntity profileEntity = this.profileService.getProfileEntity(symbol);
    if (profileEntity == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(null); // 或者回傳錯誤訊息 JSON
    }
    return ResponseEntity.ok(this.profileMapper.mapToDto(profileEntity));
}

  
}
