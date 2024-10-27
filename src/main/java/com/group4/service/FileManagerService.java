package com.group4.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public interface FileManagerService {

	public byte[] read(String path,String name);
	
	public File save(String path, MultipartFile file);
	
}
