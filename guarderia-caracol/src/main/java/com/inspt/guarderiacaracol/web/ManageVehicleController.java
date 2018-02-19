package com.inspt.guarderiacaracol.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inspt.guarderiacaracol.dto.VehicleDTO;
import com.inspt.guarderiacaracol.service.IVehicleService;

@Controller
@RequestMapping("/api")
public class ManageVehicleController {

	@Autowired
	private IVehicleService vehicleService;
	
	@RequestMapping(value = "/vehicles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<VehicleDTO> getAll(@RequestParam(name = "u", required = false) Long ownerId, @RequestParam(name = "f", required = false) Long vehicleFamilyId) {
		List<VehicleDTO> vehicleDTOs;
		if (ownerId != null && vehicleFamilyId != null) {
			vehicleDTOs = vehicleService.findByUserAndFamily(ownerId, vehicleFamilyId);
		} else {
			vehicleDTOs = vehicleService.findAll();
		}
		return vehicleDTOs;
	}
	
	@RequestMapping(value = "/vehicles/create", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody VehicleDTO createVehicle(VehicleDTO vehicleDTO) {
		return vehicleService.saveOrUpdate(vehicleDTO);
	}
	
	@RequestMapping(value = "/vehicles/user/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<VehicleDTO> getUserVehicles(@PathVariable(required = true) Long userId) {
		return vehicleService.findByUserId(userId);
	}
	
}
