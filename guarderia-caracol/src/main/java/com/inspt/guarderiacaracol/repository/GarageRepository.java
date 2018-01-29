package com.inspt.guarderiacaracol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inspt.guarderiacaracol.domain.Garage;

public interface GarageRepository extends JpaRepository<Garage, Long> {
	
	List<Garage> findAllByZoneId(Long zoneId);
	
}
