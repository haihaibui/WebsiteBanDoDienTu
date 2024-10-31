package com.group4.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.dao.NguoiDungDAO;
import com.group4.dto.SoLuongKhachDangKyTheoThangDTO;
import com.group4.service.NguoiDungService;

@Service
public class NguoiDungServiceImp implements NguoiDungService{

	@Autowired
	NguoiDungDAO ndDao;
	
	@Override
	public List<SoLuongKhachDangKyTheoThangDTO> getTkSoLuongKhachDangKyTheoThang() {
		return ndDao.getThongKeKhachDangKyTheoThang();
	}
	
	
	
}
