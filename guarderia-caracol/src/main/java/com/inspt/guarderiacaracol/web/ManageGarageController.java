package com.inspt.guarderiacaracol.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inspt.guarderiacaracol.dto.GarageDTO;
import com.inspt.guarderiacaracol.dto.VehicleDTO;
import com.inspt.guarderiacaracol.service.IGarageService;

@RestController
@RequestMapping("/api")
public class ManageGarageController {

	@Autowired
	private IGarageService garageService;
	
	@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE', 'PARTNER')")
	@RequestMapping(value = "/garages", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<GarageDTO> getGarageByZone(@RequestParam("z") Long zoneId) {
		return garageService.findByZoneId(zoneId);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE', 'PARTNER')")
	@RequestMapping(value = "/garages/{garageId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public GarageDTO getGarageById(@PathVariable Long garageId) {
		return garageService.findById(garageId);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/garages/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public GarageDTO create(@RequestBody GarageDTO garageDTO) {
		return garageService.saveOrUpdate(garageDTO);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = RuntimeException.class)
	@RequestMapping(value = "/garages/change-vehicle/{garageId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public VehicleDTO changeVehicle(@PathVariable Long garageId, @RequestBody Long vehicleId) {
		return garageService.changeVehicle(garageId, vehicleId);
	}
	
}
