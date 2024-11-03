package com.group4.service;

import java.util.List;
import java.util.Optional;

import com.group4.entity.ChungLoai;

public interface ChungLoaiService {
	
	public List<ChungLoai> findAll();
	
	public Optional<ChungLoai> findById(String id);
	
	public ChungLoai save(ChungLoai cl);
	
	public boolean existsById(String id);
	
	public void deleteById(String id);
	
}
