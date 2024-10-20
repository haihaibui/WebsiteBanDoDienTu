package com.group4.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.group4.dao.ChungLoaiDAO;
import com.group4.entity.ChungLoai;
import com.group4.service.ChungLoaiService;

public class ChungLoaiServiceImp implements ChungLoaiService{

	@Autowired
	ChungLoaiDAO clDao;
	
	@Override
	public List<ChungLoai> findClAll() {
		return clDao.findAll();
	}

}
