package com.group4.controller.rest;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group4.dao.DonHangChiTietDAO;
import com.group4.entity.DonHangChiTiet;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/DonHangChiTiet")
public class DonHangChiTietRestController {

	@Autowired
	DonHangChiTietDAO dhctDao;
	
	@GetMapping("/TimTheoMaDonHang/{id}")
	public ResponseEntity<Collection<DonHangChiTiet>> restFindDhctByMadh(@PathVariable("id") Integer id){
		List<DonHangChiTiet> listDhct = dhctDao.findAllByDonHang_MaDonHang(id);
		if(listDhct.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(listDhct);
	}
	
}
