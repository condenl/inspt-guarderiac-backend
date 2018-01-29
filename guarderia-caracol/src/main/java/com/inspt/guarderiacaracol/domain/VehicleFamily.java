package com.inspt.guarderiacaracol.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE_FAMILY", schema = "GUARDERIAC")
public class VehicleFamily implements Serializable {
	
	private static final long serialVersionUID = 6970324762897457507L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "vehicle_family_gen")
	@SequenceGenerator(name = "vehicle_family_gen", sequenceName = "VEHICLE_FAMILY_SEQ")
	@Column(name = "VEFA_ID")
	private Long id;
	
	@Column(name = "VEFA_NAME")
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "VEFA_DIMENSION")
	private DimensionEnum dimension;

	public VehicleFamily() { }
	
	public VehicleFamily(Long id) {
		this.id = id;
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
	
	public DimensionEnum getDimension() {
		return dimension;
	}
	
	public void setDimension(DimensionEnum dimension) {
		this.dimension = dimension;
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
		VehicleFamily other = (VehicleFamily) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
