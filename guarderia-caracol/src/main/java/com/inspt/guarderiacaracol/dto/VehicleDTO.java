package com.inspt.guarderiacaracol.dto;

import com.inspt.guarderiacaracol.domain.Vehicle;

public class VehicleDTO {

	private Long id;
    
    private String enrollment;
    
    private String name;
    
    private VehicleFamilyDTO vehicleFamilyDTO;
    
    private AppUserDTO appUserDTO;
    
    private PhotoDTO photoDTO;
	
    public VehicleDTO() { }
    
	public VehicleDTO(Vehicle vehicle) {
		this.id = vehicle.getId();
		this.enrollment = vehicle.getEnrollment();
		this.name = vehicle.getName();
		this.vehicleFamilyDTO = new VehicleFamilyDTO(vehicle.getVehicleFamily());
		if (vehicle.getAppUser() != null) {
			this.appUserDTO = new AppUserDTO(vehicle.getAppUser());
		}
		if (vehicle.getPhoto() != null) {
			this.photoDTO = new PhotoDTO(vehicle.getPhoto());
		}
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

	public VehicleFamilyDTO getVehicleFamilyDTO() {
		return vehicleFamilyDTO;
	}

	public void setVehicleFamilyDTO(VehicleFamilyDTO vehicleFamilyDTO) {
		this.vehicleFamilyDTO = vehicleFamilyDTO;
	}

	public AppUserDTO getAppUserDTO() {
		return appUserDTO;
	}

	public void setAppUserDTO(AppUserDTO appUserDTO) {
		this.appUserDTO = appUserDTO;
	}
	
	public PhotoDTO getPhotoDTO() {
		return photoDTO;
	}
	
	public void setPhotoDTO(PhotoDTO photoDTO) {
		this.photoDTO = photoDTO;
	}
	
}
