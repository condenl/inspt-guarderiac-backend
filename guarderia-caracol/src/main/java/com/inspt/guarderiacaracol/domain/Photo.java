package com.inspt.guarderiacaracol.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PHOTO", schema = "GUARDERIAC")
public class Photo implements Serializable {
	
	private static final long serialVersionUID = -3153858145494243944L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "photo_gen")
	@SequenceGenerator(name = "photo_gen", sequenceName = "PHOTO_SEQ")
	@Column(name = "PHOT_ID")
	private Long id;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "PHOT_DATA")
	private byte[] data;
	
	public Photo() { }
	
	public Photo(byte[] data) {
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
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
		Photo other = (Photo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
