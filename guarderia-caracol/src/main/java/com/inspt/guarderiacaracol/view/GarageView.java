package com.inspt.guarderiacaracol.view;

import java.time.LocalDateTime;

import com.inspt.guarderiacaracol.dto.GarageDTO;

public class GarageView {

	private Long id;
	
    private Integer stateCounter;
	
    private Boolean maintenanceService;
	
    private Integer kWHConsumed;
    
    private Long vehicleId;
    
    private LocalDateTime vehicleAssignationDate;
    
    private LocalDateTime acquireDate;
    
    private Long appUserId;
	
	public GarageDTO toDTO() {
		GarageDTO garageDTO = new GarageDTO();
		garageDTO.setId(id);
		garageDTO.setStateCounter(stateCounter);
		garageDTO.setMaintenanceService(maintenanceService);
		garageDTO.setkWHConsumed(kWHConsumed);
		garageDTO.setVehicleId(vehicleId);
		garageDTO.setVehicleAssignationDate(vehicleAssignationDate);
		garageDTO.setAcquireDate(acquireDate);
		garageDTO.setAppUserId(appUserId);
		return garageDTO;
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
