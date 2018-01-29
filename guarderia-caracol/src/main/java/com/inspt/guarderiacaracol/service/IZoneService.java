package com.inspt.guarderiacaracol.service;

import java.util.List;

import com.inspt.guarderiacaracol.dto.ZoneDTO;

public interface IZoneService {
	
	List<ZoneDTO> findAll();
	
	ZoneDTO findById(Long id);
	
}
