package com.inspt.guarderiacaracol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inspt.guarderiacaracol.domain.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> { }
