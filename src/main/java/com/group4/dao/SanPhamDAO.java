package com.group4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.group4.entity.SanPham;

public interface SanPhamDAO extends JpaRepository<SanPham, String>, JpaSpecificationExecutor<SanPham>{

}
