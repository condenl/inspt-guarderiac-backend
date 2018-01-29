package com.inspt.guarderiacaracol.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inspt.guarderiacaracol.dto.VehicleFamilyDTO;
import com.inspt.guarderiacaracol.service.IVehicleFamilyService;

@RestController
@RequestMapping("/api")
public class ManageVehicleFamilyController {
	
	@Autowired
	private IVehicleFamilyService vehicleFamilyService;
	
	@RequestMapping(value = "/vehicle-families", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<VehicleFamilyDTO> getAll() {
		return vehicleFamilyService.findAll();
	}
	
}
