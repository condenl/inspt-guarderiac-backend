package com.inspt.guarderiacaracol.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inspt.guarderiacaracol.domain.Garage;

public class GarageDTO {

    private Long id;
	
    private Integer stateCounter;
	
    private boolean maintenanceService;
	
    private Integer kWHConsumed;
    
    private VehicleDTO vehicleDTO;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime vehicleAssignationDate;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime acquireDate;
    
    private AppUserDTO appUserDTO;
    
    private ZoneDTO zoneDTO;
    
    public GarageDTO() { }

    public GarageDTO(Garage garage) {
    	this.id = garage.getId();
    	this.stateCounter = garage.getStateCounter();
    	this.maintenanceService = garage.getMaintenanceService();
    	this.kWHConsumed = garage.getkWHConsumed();
    	this.vehicleDTO = garage.getVehicle() != null ? new VehicleDTO(garage.getVehicle()) : null;
    	this.vehicleAssignationDate = garage.getVehicleAssignationDate();
    	this.acquireDate = garage.getAcquireDate();
    	this.appUserDTO = new AppUserDTO(garage.getAppUser());
    	this.zoneDTO = new ZoneDTO(garage.getZone());
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStateCounter() {
		return stateCounter;
	}

	public void setStateCounter(Integer stateCounter) {
		this.stateCounter = stateCounter;
	}

	public boolean getMaintenanceService() {
		return maintenanceService;
	}

	public void setMaintenanceService(boolean maintenanceService) {
		this.maintenanceService = maintenanceService;
	}

	public Integer getkWHConsumed() {
		return kWHConsumed;
	}

	public void setkWHConsumed(Integer kWHConsumed) {
		this.kWHConsumed = kWHConsumed;
	}

	public VehicleDTO getVehicleDTO() {
		return vehicleDTO;
	}

	public void setVehicleDTO(VehicleDTO vehicleDTO) {
		this.vehicleDTO = vehicleDTO;
	}

	public LocalDateTime getVehicleAssignationDate() {
		return vehicleAssignationDate;
	}

	public void setVehicleAssignationDate(LocalDateTime vehicleAssignationDate) {
		this.vehicleAssignationDate = vehicleAssignationDate;
	}

	public LocalDateTime getAcquireDate() {
		return acquireDate;
	}

	public void setAcquireDate(LocalDateTime acquireDate) {
		this.acquireDate = acquireDate;
	}

	public AppUserDTO getAppUserDTO() {
		return appUserDTO;
	}

	public void setAppUserDTO(AppUserDTO appUserDTO) {
		this.appUserDTO = appUserDTO;
	}
    
	public ZoneDTO getZoneDTO() {
		return zoneDTO;
	}
	
	public void setZoneDTO(ZoneDTO zoneDTO) {
		this.zoneDTO = zoneDTO;
	}
	
}
