package com.group4.service;

import java.util.List;
import java.util.Optional;

import com.group4.entity.NhaCungCap;

public interface NhaCungCapService {

	public List<NhaCungCap> findAll();
	
	public Optional<NhaCungCap> findById(String id);
	
	public NhaCungCap save(NhaCungCap ncc);
	
	public boolean existsById(String id);
	
	public void deleteById(String id);
	
}
