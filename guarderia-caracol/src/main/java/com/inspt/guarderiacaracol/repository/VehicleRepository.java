package com.inspt.guarderiacaracol.repository;

import java.util.List;

import com.inspt.guarderiacaracol.domain.Vehicle;

public interface VehicleRepository extends ICustomRepository<Vehicle, Long> { 
	
	List<Vehicle> findByAppUserId(Long appUserId);
	
}
