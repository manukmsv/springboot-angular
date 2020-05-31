package com.interview.app.springbootapp.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.interview.app.springbootapp.service.ImageService;

@PropertySource("classpath:image.properties")
@RestController
public class ImageController {

	@Autowired
	ImageService imageService;

	@CrossOrigin(origins = "${image.crossorgin}")
	@RequestMapping("/imgname")
	@ResponseBody
	public String getImageName() {
		return imageService.readImageName();
	}

	@CrossOrigin(origins = "${image.crossorgin}")
	@RequestMapping(value = "/image", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String getImages() throws IOException {
		return imageService.readImage();
	}
}
