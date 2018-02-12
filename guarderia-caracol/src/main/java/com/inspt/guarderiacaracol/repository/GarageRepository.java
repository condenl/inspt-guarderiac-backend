package com.inspt.guarderiacaracol.repository;

import java.util.List;

import com.inspt.guarderiacaracol.domain.Garage;

public interface GarageRepository extends ICustomRepository<Garage, Long> {
	
	List<Garage> findAllByZoneId(Long zoneId);
	
}
