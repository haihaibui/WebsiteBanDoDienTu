package com.group4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group4.dao.ChungLoaiDAO;
import com.group4.dao.DonHangDAO;
import com.group4.dao.NguoiDungDAO;
import com.group4.dao.NhaCungCapDAO;
import com.group4.dao.SanPhamDAO;
import com.group4.dao.ThuocTinhDacBietDAO;
import com.group4.entity.ChungLoai;
import com.group4.entity.DonHang;
import com.group4.entity.NguoiDung;
import com.group4.entity.NhaCungCap;
import com.group4.entity.SanPham;
import com.group4.entity.ThuocTinhDacBiet;
import com.group4.util.SessionUtil;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TrangChuController {
	
	@GetMapping("/admin")
	public String quanLyIndex() {
		//Trả về trang quản lý chính thức từ static
		return "redirect:/admin/html/QuanLyIndex.html";
	}
	
}
