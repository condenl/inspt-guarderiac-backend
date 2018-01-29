package com.inspt.guarderiacaracol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspt.guarderiacaracol.dto.VehicleFamilyDTO;
import com.inspt.guarderiacaracol.repository.VehicleFamilyRepository;
import com.inspt.guarderiacaracol.service.IVehicleFamilyService;

@Service
public class VehicleFamilyService implements IVehicleFamilyService {

	@Autowired
	private VehicleFamilyRepository vehicleFamilyRespository;
	
	@Override
	public List<VehicleFamilyDTO> findAll() {
		return vehicleFamilyRespository.findAll()
				.stream()
				.map(VehicleFamilyDTO::new)
				.collect(Collectors.toList());
	}
	
}
