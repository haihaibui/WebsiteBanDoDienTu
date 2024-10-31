package com.group4.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.dao.DonHangDAO;
import com.group4.dto.DoanhThuTheoChungLoaiDTO;
import com.group4.dto.DoanhThuTheoNhaCungCap;
import com.group4.dto.DoanhThuTheoThangDTO;
import com.group4.service.DonHangService;

@Service
public class DonHangServiceImp implements DonHangService{

	@Autowired
	DonHangDAO dhDao;
	
	@Override
	public List<DoanhThuTheoThangDTO> getTkDoanhThuTheoThang() {
		return dhDao.getDoanhThuTheoThang();
	}

	@Override
	public List<DoanhThuTheoChungLoaiDTO> getTkDoanhThuTheoCl() {
		return dhDao.getDoanhThuTheoChungLoai();
	}

	@Override
	public List<DoanhThuTheoNhaCungCap> getTkDoanhThuTheoNcc() {
		return dhDao.getDoanhThuTheoNhaCungCap();
	}

}
