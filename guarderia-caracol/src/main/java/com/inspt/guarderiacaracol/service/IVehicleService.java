package com.inspt.guarderiacaracol.service;

import java.util.List;

import com.inspt.guarderiacaracol.dto.VehicleDTO;

public interface IVehicleService {

	List<VehicleDTO> findAll();
	
	VehicleDTO saveOrUpdate(VehicleDTO vehicleDTO);
	
	List<VehicleDTO> findByUserId(Long id);
	
}
