package com.inspt.guarderiacaracol.dto;

import java.time.LocalDateTime;

import com.inspt.guarderiacaracol.domain.Garage;

public class GarageDTO {

    private Long id;
	
    private Integer stateCounter;
	
    private Boolean maintenanceService;
	
    private Integer kWHConsumed;
    
    private Long vehicleId;
    
    private LocalDateTime vehicleAssignationDate;
    
    private LocalDateTime acquireDate;
    
    private Long appUserId;
    
    public GarageDTO() { }

    public GarageDTO(Garage garage) {
    	this.id = garage.getId();
    	this.stateCounter = garage.getStateCounter();
    	this.maintenanceService = garage.getMaintenanceService();
    	this.kWHConsumed = garage.getkWHConsumed();
    	this.vehicleId = garage.getVehicle() != null ? garage.getVehicle().getId(): null;
    	this.vehicleAssignationDate = garage.getVehicleAssignationDate();
    	this.acquireDate = garage.getAcquireDate();
    	this.appUserId = garage.getAppUser() != null ? garage.getAppUser().getId() : null;
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

	public Boolean getMaintenanceService() {
		return maintenanceService;
	}

	public void setMaintenanceService(Boolean maintenanceService) {
		this.maintenanceService = maintenanceService;
	}

	public Integer getkWHConsumed() {
		return kWHConsumed;
	}

	public void setkWHConsumed(Integer kWHConsumed) {
		this.kWHConsumed = kWHConsumed;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
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

	public Long getAppUserId() {
		return appUserId;
	}

	public void setAppUserId(Long appUserId) {
		this.appUserId = appUserId;
	}
    
}
