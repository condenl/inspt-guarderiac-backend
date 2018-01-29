package com.inspt.guarderiacaracol.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ZONE", schema = "GUARDERIAC")
public class Zone implements Serializable {
	
	private static final long serialVersionUID = 3985725222847519106L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "zone_gen")
	@SequenceGenerator(name = "zone_gen", sequenceName = "ZONE_SEQ")
	@Column(name = "ZONE_ID")
    private Long id;
    
	@Column(name = "ZONE_LETTER")
    private Character letter;
	
	@ManyToOne
	@JoinColumn(name = "ZONE_VEFA_ID", foreignKey = @ForeignKey(name = "ZONE_VEFA_FK"))
    private VehicleFamily vehicleFamily;
	
    @OneToMany(mappedBy = "zone")
    private List<Garage> garages;
    
    @ManyToOne
    @JoinColumn(name = "ZONE_KIGA_ID", foreignKey = @ForeignKey(name = "ZONE_KIGA_FK"))
    private Kindergarten kindergarten;

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

	public VehicleFamily getVehicleFamily() {
		return vehicleFamily;
	}

	public void setVehicleFamily(VehicleFamily vehicleFamily) {
		this.vehicleFamily = vehicleFamily;
	}

	public List<Garage> getGarages() {
		return garages;
	}

	public void setGarages(List<Garage> garages) {
		this.garages = garages;
	}

	public Kindergarten getKindergarten() {
		return kindergarten;
	}

	public void setKindergarten(Kindergarten kindergarten) {
		this.kindergarten = kindergarten;
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
		Zone other = (Zone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
}