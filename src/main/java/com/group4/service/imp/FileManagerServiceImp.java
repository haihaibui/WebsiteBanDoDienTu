package com.group4.service.imp;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.group4.service.FileManagerService;

import jakarta.servlet.ServletContext;

@Service
public class FileManagerServiceImp implements FileManagerService{
	
	@Autowired
	ServletContext app;
	
	private Path getPath(String folder, String name) {
		File dir = Paths.get(app.getRealPath("/dynamic/image/"),folder).toFile();
		if(!dir.exists()) {
			dir.mkdirs();
		}
		return Paths.get(dir.getAbsolutePath(), name);	
	}
	
	@Override
	public byte[] read(String folder,String name) {
		Path path = this.getPath(folder, name);
		try {
			return Files.readAllBytes(path);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void save(String folder, MultipartFile file) {
		Path path = this.getPath(folder, file.getOriginalFilename());
		try {
			file.transferTo(path);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(String folder, String name) {
		try {
			Path path = this.getPath(folder, name);
			path.toFile().delete();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
