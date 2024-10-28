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
	
	@GetMapping("/{folder}/{name}")
	public ResponseEntity<byte[]> download(@PathVariable("name") String name, @PathVariable("folder") String folder){
		try {
			byte[] img = fileService.read(folder, name);
			return ResponseEntity.ok(img);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}
		
	
	@PostMapping("/{folder}")
	public ResponseEntity<Void> saveFileSp(@PathVariable("folder") String folder,@RequestParam("file") MultipartFile file){
		try {
			fileService.save(folder, file);
			return ResponseEntity.ok().build();
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
