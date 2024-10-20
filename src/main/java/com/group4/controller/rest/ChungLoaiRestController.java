package com.group4.controller.rest;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group4.dao.ChungLoaiDAO;
import com.group4.entity.ChungLoai;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/ChungLoai")
public class ChungLoaiRestController {
	
	@Autowired
	ChungLoaiDAO clDao;
	
	@GetMapping()
	public ResponseEntity<Collection<ChungLoai>> restGetAllCl(){
		List<ChungLoai> listCl = clDao.findAll();
		if(listCl.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(listCl);
	}
	
	@GetMapping("{x}")
	public ResponseEntity<ChungLoai> restGetClById(@PathVariable("x") String id) {
		Optional<ChungLoai> optional = clDao.findById(id);
		if(optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optional.get());
	}
	
	@PostMapping()
	public ResponseEntity<ChungLoai> restPostCl(@RequestBody ChungLoai cl){
		if(clDao.existsById(cl.getMaChungLoai())) {
			return ResponseEntity.badRequest().build();
		}
		clDao.save(cl);
		return ResponseEntity.ok(cl);
	}
	
	@PutMapping("{x}")
	public ResponseEntity<ChungLoai> restPutCl(@RequestBody ChungLoai cl, @PathVariable("x") String id){
		if(!clDao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		clDao.save(cl);
		return ResponseEntity.ok(cl);
	}
	
	@DeleteMapping("{x}")
	public ResponseEntity<Void> restDeleteCl(@PathVariable("x") String id){
		if(!clDao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		clDao.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	
}
