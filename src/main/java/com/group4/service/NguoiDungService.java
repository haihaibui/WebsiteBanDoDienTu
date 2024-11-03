package com.group4.service;

import java.util.List;
import java.util.Optional;

import com.group4.dto.SoLuongKhachDangKyTheoThangDTO;
import com.group4.entity.NguoiDung;

public interface NguoiDungService {
	
	public List<SoLuongKhachDangKyTheoThangDTO> getTkSoLuongKhachDangKyTheoThang();
	
	public List<NguoiDung> findAll();
	
	public Optional<NguoiDung> findById(String id);
	
	public boolean existsById(String id);
	
}
