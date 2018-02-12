package com.inspt.guarderiacaracol.dto;

import com.inspt.guarderiacaracol.domain.Zone;

public class ZoneDTO {

    private Long id;
    
    private Character letter;
	
    private VehicleFamilyDTO vehicleFamilyDTO;
    
//  private Kindergarten kindergarten;
    
    public ZoneDTO() { }
    
    public ZoneDTO(Zone zone) {
    	this.id = zone.getId();
    	this.letter = zone.getLetter();
    	this.vehicleFamilyDTO = new VehicleFamilyDTO(zone.getVehicleFamily());
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Character getLetter() {
		return letter;
	}

	public void setLetter(Character letter) {
		this.letter = letter;
	}
	
	public VehicleFamilyDTO getVehicleFamilyDTO() {
		return vehicleFamilyDTO;
	}

	public void setVehicleFamilyDTO(VehicleFamilyDTO vehicleFamilyDTO) {
		this.vehicleFamilyDTO = vehicleFamilyDTO;
	}
    
}
