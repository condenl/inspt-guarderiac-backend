package com.inspt.guarderiacaracol.web;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inspt.guarderiacaracol.service.IPhotoService;

@Controller
@RequestMapping("/api")
public class ImageController {
	
	@Autowired
	private IPhotoService photoService;
	
	@RequestMapping(value = "/image/{photoId}", method = RequestMethod.GET)
	public void getImage(@PathVariable Long photoId, HttpServletResponse response) throws IOException {
		response.setContentType("image/jpeg, image/jpg, image/png");
		try(ServletOutputStream stream = response.getOutputStream()) {
			stream.write(photoService.findDataById(photoId));
		}
	}
	
}
