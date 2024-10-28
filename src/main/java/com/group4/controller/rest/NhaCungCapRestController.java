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

import com.group4.dao.NhaCungCapDAO;
import com.group4.entity.NhaCungCap;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/NhaCungCap")
public class NhaCungCapRestController {

	@Autowired
	NhaCungCapDAO nccDao;
	
	@GetMapping()
	public ResponseEntity<Collection<NhaCungCap>> restGetAllNcc(){
		List<NhaCungCap> listNcc = nccDao.findAll();
		if(listNcc.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(listNcc);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<NhaCungCap> restGetNccById(@PathVariable("id") String id){
		Optional<NhaCungCap> ncc = nccDao.findById(id);
		if(ncc.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(ncc.get());
	}
	
	@PostMapping()
	public ResponseEntity<NhaCungCap> restPostNcc(@RequestBody NhaCungCap ncc){
		if(nccDao.existsById(ncc.getMaNhaCungCap())) {
			return ResponseEntity.badRequest().build();
		}
		nccDao.save(ncc);
		return ResponseEntity.ok(ncc);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<NhaCungCap> restPutNcc(@RequestBody NhaCungCap ncc, @PathVariable("id") String id){
		if(!nccDao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		nccDao.save(ncc);
		return ResponseEntity.ok(ncc);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> restDeleteNcc(@PathVariable("id") String id){
		if(!nccDao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		nccDao.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}
