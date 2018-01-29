package com.inspt.guarderiacaracol.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inspt.guarderiacaracol.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	
	Role findByName(String name);
	
}
