package com.group4.service;

import java.util.List;
import java.util.Optional;

import com.group4.entity.ThuocTinhDacBiet;

public interface ThuocTinhDacBietService {
	
	public List<ThuocTinhDacBiet> findAll();
	
	public Optional<ThuocTinhDacBiet> findById(String id);
	
	public boolean existsById(String id);
	
	public ThuocTinhDacBiet save(ThuocTinhDacBiet ttdb);
	
	public void deleteById(String id);
	
}
