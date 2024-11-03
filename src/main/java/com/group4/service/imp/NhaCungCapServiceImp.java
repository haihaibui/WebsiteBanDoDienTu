package com.group4.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.dao.NhaCungCapDAO;
import com.group4.entity.NhaCungCap;
import com.group4.service.NhaCungCapService;

@Service
public class NhaCungCapServiceImp implements NhaCungCapService{

	@Autowired
	NhaCungCapDAO nccDao;
	
	@Override
	public List<NhaCungCap> findAll() {
		return nccDao.findAll();
	}

	@Override
	public Optional<NhaCungCap> findById(String id) {
		return nccDao.findById(id);
	}

	@Override
	public NhaCungCap save(NhaCungCap ncc) {
		return nccDao.save(ncc);
	}

	@Override
	public boolean existsById(String id) {
		return nccDao.existsById(id);
	}

	@Override
	public void deleteById(String id) {
		nccDao.deleteById(id);
	}

}
