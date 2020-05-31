package com.interview.app.springbootapp;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

import com.interview.app.springbootapp.service.ImageService;

@PropertySource("classpath:imagetest.properties")
@SpringBootTest
class SpringbootappApplicationTests {

	@Autowired
	ImageService imageService;
	
	@Test
	void readImageNameTest() {
		assertEquals("Spring Boot Angular JS", imageService.readImageName());
	}
	
	@Test
	void readImageTest() {
		try {
			assertNotNull(imageService.readImage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
