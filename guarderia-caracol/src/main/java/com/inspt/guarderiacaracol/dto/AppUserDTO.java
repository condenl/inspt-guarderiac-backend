package com.inspt.guarderiacaracol.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inspt.guarderiacaracol.domain.AppUser;

public class AppUserDTO {
	
	private Long id;
    
    private String name;
	
    private String address;
    
    private String document;
    
    private String phone;
    
    @JsonIgnore
    private LocalDateTime entryDate;
    
    private String username;
    
    private String password;
	
	private boolean admin;
	
	public AppUserDTO() { }
	
	public AppUserDTO(AppUser appUser) {
		this.id = appUser.getId();
	    this.name = appUser.getName();
	    this.address = appUser.getAddress();
	    this.document = appUser.getDocument();
	    this.phone = appUser.getPhone();
	    this.entryDate = appUser.getEntryDate();
	    this.username = appUser.getUsername();
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
	
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
}
