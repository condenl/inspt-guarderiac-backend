package com.inspt.guarderiacaracol.domain;

import java.io.Serializable;

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
@Table(name = "VEHICLE", schema = "GUARDERIAC")
public class Vehicle implements Serializable {
	
	private static final long serialVersionUID = 4375026096462071541L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "vehicle_gen")
	@SequenceGenerator(name = "vehicle_gen", sequenceName = "VEHICLE_SEQ")
	@Column(name = "VEHI_ID")
    private Long id;
    
	@Column(name = "VEHI_ENROLLMENT", nullable = false)
    private String enrollment;
    
	@Column(name = "VEHI_NAME", nullable = false)
    private String name;
    
	@ManyToOne
	@JoinColumn(name = "VEHI_VEFA_ID", nullable = false, foreignKey = @ForeignKey(name = "VEHI_VEFA_FK"))
    private VehicleFamily vehicleFamily;
    
	@OneToOne
	@JoinColumn(name = "VEHI_APUS_ID", foreignKey = @ForeignKey(name = "VEHI_APUS_FK"))
    private AppUser appUser;
	
	public Vehicle() { }
	
	public Vehicle(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(String enrollment) {
		this.enrollment = enrollment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VehicleFamily getVehicleFamily() {
		return vehicleFamily;
	}

	public void setVehicleFamily(VehicleFamily vehicleFamily) {
		this.vehicleFamily = vehicleFamily;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
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
		Vehicle other = (Vehicle) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
}