package com.inspt.guarderiacaracol.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.inspt.guarderiacaracol.domain.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {

	AppUser findByUsername(String username);
	
	List<AppUser> findByUsernameIgnoringCaseContaining(String term);
	
}
