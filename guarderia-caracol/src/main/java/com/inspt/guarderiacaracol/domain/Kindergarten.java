package com.inspt.guarderiacaracol.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "KINDERGARTEN", schema = "GUARDERIAC")
public class Kindergarten implements Serializable {
	
	private static final long serialVersionUID = 3565830500035273666L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "kindergarten_gen")
	@SequenceGenerator(name = "kindergarten_gen", sequenceName = "KINDERGARTEN_SEQ")
	@Column(name = "KIGA_ID")
    private Long id;
    
	@Column(name = "KIGA_NAME")
	private String name;
    
	@Column(name = "KIGA_ADDRESS")
	private String address;
    
	@OneToMany(mappedBy = "kindergarten")
	private List<Zone> zones;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Zone> getZones() {
		return zones;
	}

	public void setZones(List<Zone> zones) {
		this.zones = zones;
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
		Kindergarten other = (Kindergarten) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
