package com.group4.controller.rest;

import java.io.File;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.group4.service.FileManagerService;

import jakarta.servlet.annotation.MultipartConfig;

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
	
	@PostMapping("/SanPham")
	public ResponseEntity<Void> saveFileSp(@RequestParam("file") MultipartFile file){
		try {
			fileService.save("/static/image/SanPham", file);
			return ResponseEntity.ok().build();
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
