package com.inspt.guarderiacaracol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspt.guarderiacaracol.dto.ZoneDTO;
import com.inspt.guarderiacaracol.repository.ZoneRepository;
import com.inspt.guarderiacaracol.service.IZoneService;

@Service
public class ZoneService implements IZoneService {

	@Autowired
	private ZoneRepository zoneRepository;
	
	@Override
	public List<ZoneDTO> findAll() {
		return zoneRepository.findAll()
			.stream()
			.map(ZoneDTO::new)
			.collect(Collectors.toList());
	}

	@Override
	public ZoneDTO findById(Long id) {
		return new ZoneDTO(zoneRepository.findOne(id));
	}
	
}
