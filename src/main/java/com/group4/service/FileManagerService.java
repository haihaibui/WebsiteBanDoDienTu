package com.group4.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface FileManagerService {

	public byte[] read(String folder,String name);
	
	public void save(String folder, MultipartFile file);
	
	public void delete(String folder, String name);
	
}
