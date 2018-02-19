package com.inspt.guarderiacaracol.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspt.guarderiacaracol.repository.PhotoRepository;
import com.inspt.guarderiacaracol.service.IPhotoService;

@Service
public class PhotoService implements IPhotoService {
	
	@Autowired
	private PhotoRepository photoRepository;
	
	@Override
	public byte[] findDataById(Long id) {
		return photoRepository.findOne(id).getData();
	}
	
}
