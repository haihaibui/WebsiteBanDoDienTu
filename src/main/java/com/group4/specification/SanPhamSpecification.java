package com.group4.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.group4.entity.SanPham;

@Component
public class SanPhamSpecification {
	
	public Specification<SanPham> hasTenSanPham(String tenSanPham){
		return (root, query, cb) -> tenSanPham==null || tenSanPham.trim().isEmpty()
				?cb.conjunction() // Trả về một điều kiện luôn đúng nếu không có tên sản phẩm
				:cb.like(root.get("tenSanPham"),"%"+tenSanPham+"%"); //cb.like để tìm kiếm có chứa từ khóa
	}
	
}
