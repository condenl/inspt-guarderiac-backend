package com.inspt.guarderiacaracol.view;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.inspt.guarderiacaracol.dto.AppUserDTO;

public class AppUserView {

	private Long id;
    
	@NotNull
	@Size(min = 1)
    private String name;
	
    private String address;
    
    private String document;
    
    @NotNull
    @Size(min = 1)
    private String phone;
    
    private LocalDateTime entryDate;
    
    @NotNull
    @Size(min = 1)
    private String username;
    
    @NotNull
    @Size(min = 1)
    private String password;
	
	private boolean admin;

	public AppUserDTO toDTO() {
		AppUserDTO appUserDTO = new AppUserDTO();
		appUserDTO.setName(name);
		appUserDTO.setAddress(address);
		appUserDTO.setDocument(document);
		appUserDTO.setPhone(phone);
		appUserDTO.setUsername(username);
		appUserDTO.setPassword(password);
		return appUserDTO;
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
