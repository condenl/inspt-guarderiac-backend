package com.inspt.guarderiacaracol.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "APP_USER", schema = "GUARDERIAC")
public class AppUser implements Serializable {
	
	private static final long serialVersionUID = -8156858258879633604L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "apus_user_gen")
    @SequenceGenerator(name = "apus_user_gen", sequenceName = "APP_USER_SEQ")
	@Column(name = "APUS_ID")
	private Long id;
    
	@Column(name = "APUS_NAME")
    private String name;
	
	@Column(name = "APUS_ADDRESS")
    private String address;
    
	@Column(name = "APUS_DOCUMENT")
    private String document;
    
	@Column(name = "APUS_PHONE")
    private String phone;
    
	@Column(name = "APUS_ENTRY_DATE")
    private LocalDateTime entryDate;
    
	@Column(name = "APUS_USERNAME")
    private String username;
	
	@Column(name = "APUS_PASSWORD")
    private String password;
	
	@Column(name = "APUS_ACTIVE")
	private boolean active;
	
	@Column(name = "APUS_ADMIN")
	private boolean admin;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "APP_USER_ROLE", joinColumns = @JoinColumn(name = "APUS_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private Set<Role> roles;
	
	public AppUser() { }
	
	public AppUser(Long id) {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDateTime getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public boolean isAdmin() {
		return admin;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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
		AppUser other = (AppUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
}