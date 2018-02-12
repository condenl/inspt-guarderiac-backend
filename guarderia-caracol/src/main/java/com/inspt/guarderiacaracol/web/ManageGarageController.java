package com.inspt.guarderiacaracol.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inspt.guarderiacaracol.dto.GarageDTO;
import com.inspt.guarderiacaracol.service.IGarageService;

@RestController
@RequestMapping("/api")
public class ManageGarageController {

	@Autowired
	private IGarageService garageService;
	
	@RequestMapping(value = "/garages", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<GarageDTO> getGarageByZone(@RequestParam("z") Long zoneId) {
		return garageService.findByZoneId(zoneId);
	}
	
	@RequestMapping(value = "/garages/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public GarageDTO create(@RequestBody GarageDTO garageDTO) {
		return garageService.saveOrUpdate(garageDTO);
	}
	
}
