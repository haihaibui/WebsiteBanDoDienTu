package com.group4.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.dao.ThuocTinhDacBietDAO;
import com.group4.entity.ThuocTinhDacBiet;
import com.group4.service.ThuocTinhDacBietService;

@Service
public class ThuocTinhDacBietServiceImp implements ThuocTinhDacBietService{

	@Autowired
	ThuocTinhDacBietDAO ttdbDao;
	
	@Override
	public List<ThuocTinhDacBiet> findAll() {
		return ttdbDao.findAll();
	}

	@Override
	public Optional<ThuocTinhDacBiet> findById(String id) {
		return ttdbDao.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return ttdbDao.existsById(id);
	}

	@Override
	public ThuocTinhDacBiet save(ThuocTinhDacBiet ttdb) {
		return ttdbDao.save(ttdb);
	}

	@Override
	public void deleteById(String id) {
		ttdbDao.deleteById(id);
	}

}
