package com.inspt.guarderiacaracol.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.inspt.guarderiacaracol.dto.GarageDTO;
import com.inspt.guarderiacaracol.service.IGarageService;
import com.inspt.guarderiacaracol.view.GarageView;

@Controller
@RequestMapping("/api")
public class ManageGarageController {

	@Autowired
	private IGarageService garageService;
	
	@RequestMapping(value = "/garages", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<GarageDTO> getGarageByZone(@RequestParam("z") Long zoneId) {
		return garageService.findByZoneId(zoneId);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void create(@ModelAttribute @Valid GarageView garageView, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new RuntimeException("Invalid GarageView");
		}
		garageService.create(garageView.toDTO());
	}
	
}
