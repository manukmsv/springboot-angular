package com.interview.app.springbootapp.service;

import java.io.IOException;

public interface ImageService {

	public String readImageName();

	public String readImage() throws IOException;
}
