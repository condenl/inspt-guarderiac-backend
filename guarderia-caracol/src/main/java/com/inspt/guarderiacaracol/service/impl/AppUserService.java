package com.inspt.guarderiacaracol.service.impl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.inspt.guarderiacaracol.domain.AppUser;
import com.inspt.guarderiacaracol.domain.Role;
import com.inspt.guarderiacaracol.dto.AppUserDTO;
import com.inspt.guarderiacaracol.repository.AppUserRepository;
import com.inspt.guarderiacaracol.repository.RoleRepository;
import com.inspt.guarderiacaracol.service.IAppUserService;

@Service
public class AppUserService implements IAppUserService {

	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public AppUser findByUsername(String username) {
		return appUserRepository.findByUsername(username);
	}

	@Override
	public void save(AppUserDTO appUserDTO) {
		AppUser appUser = new AppUser();
		populateAppUser(appUser, appUserDTO);
		Role userRole = roleRepository.findByName("ADMIN");
		appUser.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        appUserRepository.save(appUser);
	}
	
	@Override
	public List<AppUserDTO> findByUsernameOrName(String term) {
		return appUserRepository.findByUsernameIgnoringCaseContaining(term)
				.stream()
				.map(AppUserDTO::new)
				.collect(Collectors.toList());
	}
	
	private void populateAppUser(AppUser appUser, AppUserDTO appUserDTO) {
		appUser.setName(appUserDTO.getName());
		appUser.setAddress(appUserDTO.getAddress());
		appUser.setDocument(appUserDTO.getDocument());
		appUser.setPhone(appUserDTO.getPhone());
		appUser.setEntryDate(LocalDateTime.now());
		appUser.setUsername(appUserDTO.getUsername());
		appUser.setPassword(bCryptPasswordEncoder.encode(appUserDTO.getPassword()));
		appUser.setActive(true);
	}
	
}
