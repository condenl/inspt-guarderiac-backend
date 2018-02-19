package com.inspt.guarderiacaracol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.inspt.guarderiacaracol.domain.Vehicle;

public interface VehicleRepository extends ICustomRepository<Vehicle, Long> { 
	
	@Query("select v from Garage g right join g.vehicle v where v.appUser.id = ?1 and g.id is null")
	List<Vehicle> findByAppUserId(Long appUserId);
	
	List<Vehicle> findByAppUserIdAndVehicleFamilyId(Long appUserId, Long vehicleFamilyId);
	
}
