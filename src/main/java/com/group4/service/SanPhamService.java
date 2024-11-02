package com.group4.service;

import java.util.List;

import com.group4.entity.SanPham;

public interface SanPhamService {
	public List<SanPham> findSpAll();
	
	public SanPham findSpById(String id);
	
	public List<SanPham> filterSanPham(String tenSanPham, String maCl);
}
