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

import com.group4.dao.NguoiDungDAO;
import com.group4.entity.NguoiDung;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/NguoiDung")
public class NguoiDungRestController {

	@Autowired
	NguoiDungDAO ndDao;
	
	@GetMapping()
	public ResponseEntity<Collection<NguoiDung>> restGetAllNd(){
		List<NguoiDung> listNd = ndDao.findAll();
		if(listNd.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(listNd);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<NguoiDung> restGetNdById(@PathVariable("id") String id){
		Optional<NguoiDung> nd = ndDao.findById(id);
		if(nd.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(nd.get());
	}
	
	@GetMapping("SoLuongKhachHang")
	public ResponseEntity<Integer> restGetSoLuongKhachHang(){
		List<NguoiDung> listKh = ndDao.findAllByVaiTroLike("Khách hàng");
		return ResponseEntity.ok(listKh.size());
	}
	
	@PostMapping()
	public ResponseEntity<NguoiDung> restPostNguoiDung(@RequestBody NguoiDung nd ){
		if(ndDao.existsById(nd.getMaNguoiDung())) {
			return ResponseEntity.badRequest().build();
		}
		ndDao.save(nd);
		return ResponseEntity.ok(nd);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<NguoiDung> restPutNguoiDung(@RequestBody NguoiDung nd, @PathVariable("id") String id){
		Optional<NguoiDung> nguoiDung = ndDao.findById(id);
		if(nguoiDung.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		ndDao.save(nd);
		return ResponseEntity.ok(nd);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> restDeleteNguoiDung(@PathVariable("id") String id){
		if(!ndDao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		ndDao.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}
