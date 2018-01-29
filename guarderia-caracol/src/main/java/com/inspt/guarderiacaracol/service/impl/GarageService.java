package com.inspt.guarderiacaracol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspt.guarderiacaracol.domain.Garage;
import com.inspt.guarderiacaracol.dto.GarageDTO;
import com.inspt.guarderiacaracol.repository.GarageRepository;
import com.inspt.guarderiacaracol.service.IGarageService;

@Service
public class GarageService implements IGarageService {
	
	@Autowired
	private GarageRepository garageRepository;
	
	@Override
	public List<GarageDTO> findByZoneId(Long id) {
		return garageRepository.findAllByZoneId(id)
			.stream()
			.map(GarageDTO::new)
			.collect(Collectors.toList());
	}
	
	@Override
	public void create(GarageDTO garageDTO) {
		Garage garage = new Garage();
		populateGarage(garage, garageDTO);
		garageRepository.save(garage);
	}
	
	private void populateGarage(Garage garage, GarageDTO garageDTO) {
		
	}
	
}
