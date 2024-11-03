package com.group4.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.dao.ChungLoaiDAO;
import com.group4.entity.ChungLoai;
import com.group4.service.ChungLoaiService;

@Service
public class ChungLoaiServiceImp implements ChungLoaiService{

	@Autowired
	ChungLoaiDAO clDao;
	
	@Override
	public List<ChungLoai> findAll() {
		return clDao.findAll();
	}

	@Override
	public Optional<ChungLoai> findById(String id) {
		return clDao.findById(id);
	}

	@Override
	public ChungLoai save(ChungLoai cl) {
		return clDao.save(cl);
	}

	@Override
	public void deleteById(String id) {
		clDao.deleteById(id);
	}

	@Override
	public boolean existsById(String id) {
		if(clDao.existsById(id)) {
			return true;
		}
		return false;
	}

}
