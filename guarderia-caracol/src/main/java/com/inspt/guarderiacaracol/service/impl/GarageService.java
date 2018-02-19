package com.inspt.guarderiacaracol.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspt.guarderiacaracol.domain.AppUser;
import com.inspt.guarderiacaracol.domain.Garage;
import com.inspt.guarderiacaracol.domain.Vehicle;
import com.inspt.guarderiacaracol.domain.Zone;
import com.inspt.guarderiacaracol.dto.GarageDTO;
import com.inspt.guarderiacaracol.dto.VehicleDTO;
import com.inspt.guarderiacaracol.repository.GarageRepository;
import com.inspt.guarderiacaracol.repository.VehicleRepository;
import com.inspt.guarderiacaracol.service.IGarageService;

@Service
public class GarageService implements IGarageService {
	
	@Autowired
	private GarageRepository garageRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Override
	public List<GarageDTO> findByZoneId(Long id) {
		return garageRepository.findAllByZoneId(id)
			.stream()
			.map(GarageDTO::new)
			.collect(Collectors.toList());
	}
	
	@Override
	public GarageDTO findById(Long id) {
		return new GarageDTO(garageRepository.findOne(id));
	}
	
	@Override
	public GarageDTO saveOrUpdate(GarageDTO garageDTO) {
		Garage garage = garageDTO.getId() != null ? garageRepository.findOne(garageDTO.getId()) : new Garage();
		populateGarage(garage, garageDTO);
		garageRepository.save(garage);
		garageRepository.refresh(garage);
		return new GarageDTO(garage);
	}
	
	@Override
	public VehicleDTO changeVehicle(Long garageId, Long vehicleId) {
		Vehicle vehicle = vehicleRepository.findOne(vehicleId);
		Garage garage = garageRepository.findOne(garageId);
		garage.setVehicle(vehicle);
		garage.setVehicleAssignationDate(LocalDateTime.now());
		return new VehicleDTO(vehicle);
	}
	
	private void populateGarage(Garage garage, GarageDTO garageDTO) {
		garage.setId(garageDTO.getId());
		garage.setAppUser(new AppUser(garageDTO.getAppUserDTO().getId()));
		garage.setMaintenanceService(garageDTO.getMaintenanceService());
		garage.setZone(new Zone(garageDTO.getZoneDTO().getId()));
		if (garageDTO.getId() == null) {
			garage.setAcquireDate(LocalDateTime.now());
			garage.setkWHConsumed(0);
			garage.setStateCounter(0);
		}
		if (garageDTO.getVehicleDTO() != null && garageDTO.getVehicleDTO().getId() != null) {
			if (garage.getVehicle() == null || !garageDTO.getVehicleDTO().getId().equals(garage.getVehicle().getId())) {
				garage.setVehicleAssignationDate(LocalDateTime.now());
			}
			garage.setVehicle(new Vehicle(garageDTO.getVehicleDTO().getId()));
		} else {
			garageDTO.setVehicleDTO(null);
		}
	}
	
}
