package com.group4.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.dao.DonHangDAO;
import com.group4.dto.DoanhThuTheoChungLoaiDTO;
import com.group4.dto.DoanhThuTheoNhaCungCap;
import com.group4.dto.DoanhThuTheoThangDTO;
import com.group4.entity.DonHang;
import com.group4.service.DonHangService;

@Service
public class DonHangServiceImp implements DonHangService{

	@Autowired
	DonHangDAO dhDao;
	
	@Override
	public List<DonHang> findAll() {
		return dhDao.findAll();
	}

	@Override
	public Optional<DonHang> findById(int id) {
		return dhDao.findById(id);
	}
	
	@Override
	public boolean existsById(int id) {
		return dhDao.existsById(id);
	}

	@Override
	public DonHang save(DonHang dh) {
		return dhDao.save(dh);
	}

	@Override
	public void deleteById(int id) {
		dhDao.deleteById(id);
		
	}

	@Override
	public List<DonHang> findAllByTrangThai(String trangThai) {
		return dhDao.findAllByTrangThaiLike(trangThai);
	}

	@Override
	public int count() {
		return (int)dhDao.count();
	}
	
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
