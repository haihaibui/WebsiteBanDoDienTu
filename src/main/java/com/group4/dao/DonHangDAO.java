package com.group4.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.group4.entity.DonHang;

public interface DonHangDAO extends JpaRepository<DonHang, Integer>{
	
	//Lấy tất cả đơn hàng theo trang thái
	@Query
	List<DonHang> findAllByTrangThaiLike(String trangThai);
	
}
