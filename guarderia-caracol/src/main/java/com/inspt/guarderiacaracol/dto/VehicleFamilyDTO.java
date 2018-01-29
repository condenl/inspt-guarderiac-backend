package com.inspt.guarderiacaracol.dto;

import com.inspt.guarderiacaracol.domain.VehicleFamily;

public class VehicleFamilyDTO {
	
	private Long id;
	
	private String name;
	
	public VehicleFamilyDTO() { }
	
	public VehicleFamilyDTO(VehicleFamily vehicleFamily) {
		this.id = vehicleFamily.getId();
		this.name = vehicleFamily.getName();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
