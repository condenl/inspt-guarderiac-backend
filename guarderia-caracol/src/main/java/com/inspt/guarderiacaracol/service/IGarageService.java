package com.inspt.guarderiacaracol.service;

import java.util.List;

import com.inspt.guarderiacaracol.dto.GarageDTO;
import com.inspt.guarderiacaracol.dto.VehicleDTO;

public interface IGarageService {
	
	List<GarageDTO> findByZoneId(Long id);
	
	GarageDTO findById(Long id);
	
	GarageDTO saveOrUpdate(GarageDTO garageDTO);
	
	VehicleDTO changeVehicle(Long garageId, Long vehicleId);
	
}

