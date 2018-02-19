package com.inspt.guarderiacaracol.dto;

import org.springframework.web.multipart.MultipartFile;

import com.inspt.guarderiacaracol.domain.Photo;

/**
 * It never holds both the id and the file data, 
 * when uploading a new photo the file will be set but not the id, 
 * when getting the image the id will be set but not the file.
 *
 */
public class PhotoDTO {

	private Long id;
	
	private MultipartFile file;
	
	public PhotoDTO() { }
	
	public PhotoDTO(Photo photo) {
		this.id = photo.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
