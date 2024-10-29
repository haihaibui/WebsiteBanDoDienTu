package com.group4.controller.rest;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group4.dto.DoanhThuTheoThangDTO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/ThongKe")
public class ThongKeRestController {
	
	@GetMapping("DoanhThu")
	public ResponseEntity<Collection<DoanhThuTheoThangDTO>> restGetDoanhThuTheoThang(){
		List<DoanhThuTheoThangDTO> listDttt = Arrays.asList(
				new DoanhThuTheoThangDTO(3, 2024, 8000000),
				new DoanhThuTheoThangDTO(4, 2024, 12000000),
				new DoanhThuTheoThangDTO(5, 2024, 9000000),
				new DoanhThuTheoThangDTO(6, 2024, 10000000),
				new DoanhThuTheoThangDTO(7, 2024, 18000000),
				new DoanhThuTheoThangDTO(8, 2024, 35000000),
				new DoanhThuTheoThangDTO(9, 2024, 30000000),
				new DoanhThuTheoThangDTO(10, 2024, 40000000)
		);
		return ResponseEntity.ok(listDttt);
	}
	
}
