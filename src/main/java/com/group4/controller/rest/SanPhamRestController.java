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

import com.group4.dao.SanPhamDAO;
import com.group4.entity.SanPham;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/SanPham")
public class SanPhamRestController {

	@Autowired
	SanPhamDAO spDao;
	
	@GetMapping()
	public ResponseEntity<Collection<SanPham>> restGetAllSp(){
		List<SanPham> listSp = spDao.findAll();
		if(listSp.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(listSp);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<SanPham> restGetSpById(@PathVariable("id") String id){
		Optional<SanPham> sp = spDao.findById(id);
		if(sp.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(sp.get());
	}
	
}
