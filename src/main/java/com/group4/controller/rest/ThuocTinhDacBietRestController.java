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

import com.group4.dao.ThuocTinhDacBietDAO;
import com.group4.entity.ThuocTinhDacBiet;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/ThuocTinhDacBiet")
public class ThuocTinhDacBietRestController {

	@Autowired
	ThuocTinhDacBietDAO ttdbDao;
	
	@GetMapping()
	public ResponseEntity<Collection<ThuocTinhDacBiet>> restGetAllTtdb(){
		List<ThuocTinhDacBiet> listTtdb = ttdbDao.findAll();
		if(listTtdb.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(listTtdb);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ThuocTinhDacBiet> restGetTtdbById(@PathVariable("id") String id){
		Optional<ThuocTinhDacBiet> ttdb = ttdbDao.findById(id);
		if(ttdb.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(ttdb.get());
	}
	
}
