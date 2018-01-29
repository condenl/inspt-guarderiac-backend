package com.inspt.guarderiacaracol.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inspt.guarderiacaracol.dto.VehicleDTO;
import com.inspt.guarderiacaracol.service.IVehicleService;

@RestController
@RequestMapping("/api")
public class ManageVehicleController {

	@Autowired
	private IVehicleService vehicleService;
	
	@RequestMapping(value = "/vehicles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<VehicleDTO> getAll() {
		return vehicleService.findAll();
	}
	
	@RequestMapping(value = "/vehicles/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public VehicleDTO createVehicle(@RequestBody VehicleDTO vehicleDTO) {
		return vehicleService.saveOrUpdate(vehicleDTO);
	}
	
}
