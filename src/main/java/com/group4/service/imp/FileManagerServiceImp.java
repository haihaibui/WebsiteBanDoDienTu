package com.group4.service.imp;

import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.group4.service.FileManagerService;

@Service
public class FileManagerServiceImp implements FileManagerService{
	
	@Override
	public byte[] read(String path,String name) {
		try {
			// Sử dụng ClassPathResource để truy cập vào file trong resources
			ClassPathResource resource = new ClassPathResource(path+"/"+name);
			InputStream inputStream = resource.getInputStream();
			return inputStream.readAllBytes();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
