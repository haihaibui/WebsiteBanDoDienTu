package com.group4.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.group4.entity.NguoiDung;

public interface NguoiDungDAO extends JpaRepository<NguoiDung, String>{
	
	//Danh sách người dùng có vai trò là khách hàng
	@Query
	List<NguoiDung> findAllByVaiTroLike(String vaiTro);
	
}
