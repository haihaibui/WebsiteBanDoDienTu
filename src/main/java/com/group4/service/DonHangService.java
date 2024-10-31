package com.group4.service;

import java.util.List;

import com.group4.dto.DoanhThuTheoChungLoaiDTO;
import com.group4.dto.DoanhThuTheoNhaCungCap;
import com.group4.dto.DoanhThuTheoThangDTO;

public interface DonHangService {
	
	public List<DoanhThuTheoThangDTO> getTkDoanhThuTheoThang();
	
	public List<DoanhThuTheoChungLoaiDTO> getTkDoanhThuTheoCl();
	
	public List<DoanhThuTheoNhaCungCap> getTkDoanhThuTheoNcc();
}
