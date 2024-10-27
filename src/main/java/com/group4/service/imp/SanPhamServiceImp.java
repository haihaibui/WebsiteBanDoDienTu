package com.group4.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.dao.SanPhamDAO;
import com.group4.entity.SanPham;
import com.group4.service.SanPhamService;

@Service
public class SanPhamServiceImp implements SanPhamService{

	@Autowired
	SanPhamDAO spDao;
	
	@Override
	public List<SanPham> findSpAll() {
		return spDao.findAll();
	}

	@Override
	public SanPham findSpById(String id) {
		return spDao.findById(id).get();
	}

}
