package com.group4.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group4.service.FileManagerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/file")
public class FileManagerRestController {
	
	@Autowired
	FileManagerService fileService;
	
	@GetMapping("/SanPham/{name}")
	public ResponseEntity<byte[]> download(@PathVariable("name") String name){
		byte[] file = fileService.read("/static/image/SanPham", name);
		if(file==null) {
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(file);
	}

	
	@GetMapping("/NguoiDung/{name}")
	public ResponseEntity<byte[]> downloadNd(@PathVariable("name") String name){
		byte[] file = fileService.read("/static/image/NguoiDung", name);
		if(file==null) {
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(file);
	}

}
