package com.inspt.guarderiacaracol.service;

import java.util.List;

import com.inspt.guarderiacaracol.dto.GarageDTO;

public interface IGarageService {
	
	List<GarageDTO> findByZoneId(Long id);
	
	void create(GarageDTO garageDTO);
	
}

