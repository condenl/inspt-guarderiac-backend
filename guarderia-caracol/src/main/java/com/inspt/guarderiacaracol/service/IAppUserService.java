package com.inspt.guarderiacaracol.service;

import java.util.List;

import com.inspt.guarderiacaracol.domain.AppUser;
import com.inspt.guarderiacaracol.dto.AppUserDTO;

public interface IAppUserService {
	
	AppUser findByUsername(String username);
	
	void save(AppUserDTO appUserDTO);
	
	List<AppUserDTO> findByUsernameOrName(String term);

}
