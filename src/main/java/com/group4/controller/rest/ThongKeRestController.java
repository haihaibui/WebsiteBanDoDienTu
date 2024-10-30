package com.group4.controller.rest;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group4.dao.DonHangDAO;
import com.group4.dto.DoanhThuTheoThangDTO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/ThongKe")
public class ThongKeRestController {
	
	@Autowired
	DonHangDAO dhDao;
	
	@GetMapping("DoanhThu")
	public ResponseEntity<Collection<DoanhThuTheoThangDTO>> restGetDoanhThuTheoThang(){
		List<DoanhThuTheoThangDTO> listDttt = dhDao.getDoanhThuTheoThang();
		if(listDttt.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(listDttt);
	}
	
}
