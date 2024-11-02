package com.group4.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.group4.entity.SanPham;

import jakarta.persistence.criteria.Join;

@Component
public class SanPhamSpecification {
	
	public Specification<SanPham> hasTenSanPham(String tenSanPham){
		return (root, query, cb) -> tenSanPham==null || tenSanPham.trim().isEmpty()
				?cb.conjunction() // Trả về một điều kiện luôn đúng nếu không có tên sản phẩm
				:cb.like(root.get("tenSanPham"),"%"+tenSanPham+"%"); //cb.like để tìm kiếm có chứa từ khóa
	}
	
	public Specification<SanPham> hasChungLoai(String maCl){
		return (root, query, cb) ->{ 
			if(maCl==null || maCl.trim().isEmpty()) {
				return cb.conjunction();
			}
			//Join bảng ChungLoai để truy cập thuộc tính mã chủng loại
			Join<Object, Object> chungLoaiJoin = root.join("chungLoai"); // Tên field trong `SanPham` tham chiếu đến `ChungLoai`
			return cb.like(chungLoaiJoin.get("maChungLoai"), maCl);
		};
	}
	
}
