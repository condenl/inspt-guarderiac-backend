package com.inspt.guarderiacaracol.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ICustomRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {
	
	void refresh(T t);
	
	boolean contains(T t);
	
}
