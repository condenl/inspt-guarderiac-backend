package com.inspt.guarderiacaracol.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

public class CustomRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements ICustomRepository<T, ID> {

	private final EntityManager entityManager;
	
	public CustomRepository(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void refresh(T t) {
		entityManager.refresh(t);
	}
	
	@Override
	@Transactional
	public boolean contains(T t) {
		return entityManager.contains(t);
	}

}
