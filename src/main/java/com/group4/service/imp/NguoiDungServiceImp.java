package com.group4.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.dao.NguoiDungDAO;
import com.group4.dto.SoLuongKhachDangKyTheoThangDTO;
import com.group4.entity.NguoiDung;
import com.group4.service.NguoiDungService;

@Service
public class NguoiDungServiceImp implements NguoiDungService{

	@Autowired
	NguoiDungDAO ndDao;
	
	@Override
	public List<SoLuongKhachDangKyTheoThangDTO> getTkSoLuongKhachDangKyTheoThang() {
		return ndDao.getThongKeKhachDangKyTheoThang();
	}

	@Override
	public List<NguoiDung> findAll() {
		return ndDao.findAll();
	}

	@Override
	public Optional<NguoiDung> findById(String id) {
		return ndDao.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return ndDao.existsById(id);
	}
	
}
