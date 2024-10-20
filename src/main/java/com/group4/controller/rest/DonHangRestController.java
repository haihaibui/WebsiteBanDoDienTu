package com.group4.controller.rest;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group4.dao.DonHangDAO;
import com.group4.entity.DonHang;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/RestApi/DonHang")
public class DonHangRestController {
	
	@Autowired
	DonHangDAO dhDao;
	
	@GetMapping()
	public ResponseEntity<Collection<DonHang>> restGetAllDh(){
		List<DonHang> listDh = dhDao.findAll();
		if(listDh.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(listDh);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<DonHang> restGetDhById(@PathVariable("id") Integer id){
		Optional<DonHang> dh = dhDao.findById(id);
		if(dh.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dh.get());
	}
	
}