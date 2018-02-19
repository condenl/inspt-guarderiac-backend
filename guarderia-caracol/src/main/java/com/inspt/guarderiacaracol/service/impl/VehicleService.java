package com.inspt.guarderiacaracol.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspt.guarderiacaracol.domain.AppUser;
import com.inspt.guarderiacaracol.domain.Photo;
import com.inspt.guarderiacaracol.domain.Vehicle;
import com.inspt.guarderiacaracol.domain.VehicleFamily;
import com.inspt.guarderiacaracol.dto.VehicleDTO;
import com.inspt.guarderiacaracol.repository.VehicleRepository;
import com.inspt.guarderiacaracol.service.IVehicleService;

@Service
public class VehicleService implements IVehicleService {
	
	private static final Logger LOG = Logger.getLogger(VehicleService.class.getName());
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Override
	public List<VehicleDTO> findAll() {
		return StreamSupport.stream(vehicleRepository.findAll().spliterator(), false)
							.map(VehicleDTO::new)
							.collect(Collectors.toList());
	}
	
	@Override
	public VehicleDTO saveOrUpdate(VehicleDTO vehicleDTO) {
		Vehicle vehicle = new Vehicle();
		populateVehicle(vehicle, vehicleDTO);
		vehicleRepository.save(vehicle);
		if (vehicleRepository.contains(vehicle)) {
			vehicleRepository.refresh(vehicle);
		}
		return new VehicleDTO(vehicleRepository.findOne(vehicle.getId()));
	}
	
	@Override
	public List<VehicleDTO> findByUserId(Long id) {
		return vehicleRepository.findByAppUserId(id)
				.stream()
				.map(VehicleDTO::new)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<VehicleDTO> findByUserAndFamily(Long ownerId, Long vehicleFamilyId) {
		return vehicleRepository.findByAppUserIdAndVehicleFamilyId(ownerId, vehicleFamilyId)
				.stream()
				.map(VehicleDTO::new)
				.collect(Collectors.toList());
	}
	
	private void populateVehicle(Vehicle vehicle, VehicleDTO vehicleDTO) {
		vehicle.setId(vehicleDTO.getId());
		if (vehicleDTO.getAppUserDTO() != null && vehicleDTO.getAppUserDTO().getId() != null) {
			vehicle.setAppUser(new AppUser(vehicleDTO.getAppUserDTO().getId()));
		}
		vehicle.setVehicleFamily(new VehicleFamily(vehicleDTO.getVehicleFamilyDTO().getId()));
		vehicle.setEnrollment(vehicleDTO.getEnrollment());
		vehicle.setName(vehicleDTO.getName());
		if(vehicleDTO.getPhotoDTO() != null && vehicleDTO.getPhotoDTO().getId() == null && vehicleDTO.getPhotoDTO().getFile() != null) {
			try {
				vehicle.setPhoto(new Photo(vehicleDTO.getPhotoDTO().getFile().getBytes()));
			} catch (IOException e) {
				LOG.log(Level.SEVERE, "Error getting bytes from vehicle(enrollment: " + vehicle.getEnrollment() + ") photo", e);
			}
		}
	}
	
}
