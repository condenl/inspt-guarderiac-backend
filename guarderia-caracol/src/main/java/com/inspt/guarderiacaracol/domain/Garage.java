package com.inspt.guarderiacaracol.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "GARAGE", schema = "GUARDERIAC")
public class Garage implements Serializable {
	
	private static final long serialVersionUID = -5213146464595870207L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "garage_gen")
	@SequenceGenerator(name = "garage_gen", sequenceName = "GARAGE_SEQ")
	@Column(name = "GARA_ID")
    private Long id;
	
	@Column(name = "GARA_STATE_COUNTER")
    private Integer stateCounter;
	
	@Column(name = "GARA_MAINT_SERV")
    private Boolean maintenanceService;
	
	@Column(name = "GARA_KWH_CONSUMED")
    private Integer kWHConsumed;
    
    @OneToOne
    @JoinColumn(name = "GARA_VEHI_ID", foreignKey = @ForeignKey(name = "GARA_VEHI_FK"))
    private Vehicle vehicle;
    
    @Column(name = "GARA_VASSIGNATION_DATE")
    private LocalDateTime vehicleAssignationDate;
    
    @Column(name = "GARA_ACQUIRE_DATE")
    private LocalDateTime acquireDate;
    
    @ManyToOne
    @JoinColumn(name = "GARA_APUS_ID", foreignKey = @ForeignKey(name = "GARA_APUS_FK"))
    private AppUser appUser;
    
    @ManyToOne
    @JoinColumn(name = "GARA_ZONE_ID", foreignKey = @ForeignKey(name = "GARA_ZONE_FK"))
    private Zone zone;

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

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
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

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Garage other = (Garage) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
}