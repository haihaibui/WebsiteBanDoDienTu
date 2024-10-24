package com.group4.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.group4.entity.DonHangChiTiet;

public interface DonHangChiTietDAO extends JpaRepository<DonHangChiTiet, Integer>{
	//Load đơn hàng chi tiết theo mã đơn hàng
	@Query
	List<DonHangChiTiet> findAllByDonHang_MaDonHang(Integer maDh);
}
