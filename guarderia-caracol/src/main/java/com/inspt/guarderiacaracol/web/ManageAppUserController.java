package com.inspt.guarderiacaracol.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inspt.guarderiacaracol.dto.AppUserDTO;
import com.inspt.guarderiacaracol.service.IAppUserService;

@RestController
@RequestMapping("/api")
public class ManageAppUserController {

	@Autowired
	private IAppUserService appUserService;
	
	@RequestMapping(value = "/users/{term}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AppUserDTO> searchUserAutocomplete(@PathVariable(required = false) String term) {
		return appUserService.findByUsernameOrName(term);
	}
	
}
