package com.interview.app.springbootapp.service.impl;

import java.io.*;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.core.io.*;
import org.springframework.util.FileCopyUtils; 

import com.interview.app.springbootapp.service.ImageService;

@PropertySource("classpath:image.properties")
@Service
public class ImageServiceImpl implements ImageService {

	final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Value("${image.name}")
	private String imageName;
	@Value("${image.filename}")
	private String imageFile;

	@Autowired
	ResourceLoader resourceLoader;

	@Override
	public String readImageName() {
		return this.imageName;
	}

	@Override
	public String readImage() throws IOException {

		Resource resource = resourceLoader.getResource("classpath:spring-boot-angularjs.jpg");
    	InputStream inputStream = resource.getInputStream();
		try
		{
			// byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
			// String data = new String(bdata, StandardCharsets.UTF_8);
			byte[] bytes = StreamUtils.copyToByteArray(inputStream);
			String data = Base64.getEncoder().encodeToString(bytes);
			LOGGER.info("IMAGE READ COMPLETE");
			return data;
		} 
		catch (IOException e) 
		{
			LOGGER.error("IOException", e);
		}
		return null;
	}

}
