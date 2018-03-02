package com.inspt.guarderiacaracol.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inspt.guarderiacaracol.dto.ZoneDTO;
import com.inspt.guarderiacaracol.service.IZoneService;

@RestController
@RequestMapping("/api")
public class ManageZoneController {

	@Autowired
	private IZoneService zoneService;
	
	@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE', 'PARTNER')")
	@RequestMapping(value = "/zones", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ZoneDTO> getZones() {
		return zoneService.findAll();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE', 'PARTNER')")
	@RequestMapping(value = "/zones/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ZoneDTO getZone(@PathVariable Long id) {
		return zoneService.findById(id);
	}
	
}
