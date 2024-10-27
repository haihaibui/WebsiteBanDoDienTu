package com.group4.service.imp;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

	@Override
	public File save(String path, MultipartFile file) {
		try {
			//Tạo đường dẫn để lưu ảnh
			String resourcePath = new File("src/main/resources"+path).getAbsolutePath();
			File directory = new File(resourcePath);
			//Kiểm tra thư mục để lưu ảnh có tồn tại chưa
			if(!directory.exists()) {
				directory.mkdirs();
			}
			//Ghi file vào đường dẫn đã định
			File destinationFile = new File(directory,file.getOriginalFilename());
			file.transferTo(destinationFile);
			return destinationFile;
		}catch (Exception e) {
			throw new RuntimeException("Error saving file",e);
		}
	}
	
}
