package com.inspt.guarderiacaracol.web;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inspt.guarderiacaracol.domain.AppUser;
import com.inspt.guarderiacaracol.dto.AppUserDTO;
import com.inspt.guarderiacaracol.service.IAppUserService;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	private IAppUserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public Principal user(Principal user) {
		return user;
	}
	
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public void registration(@RequestBody AppUserDTO appUserDTO, HttpServletResponse response) {
		AppUser userExists = userService.findByUsername(appUserDTO.getUsername());
		if (userExists == null) {
			userService.save(appUserDTO);
		} else {
			response.setStatus(422);
		}
	}

}
