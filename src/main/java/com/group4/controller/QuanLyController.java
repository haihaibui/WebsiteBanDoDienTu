package com.group4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.group4.dao.DonHangDAO;
import com.group4.dao.NguoiDungDAO;
import com.group4.dao.SanPhamDAO;
import com.group4.entity.DonHang;
import com.group4.entity.NguoiDung;
import com.group4.entity.SanPham;
import com.group4.service.SessionService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class QuanLyController {
	
	@Autowired
	SessionService session;
	
	@Autowired
	SanPhamDAO spDao;
	
	@Autowired
	DonHangDAO dhDao;
	
	@Autowired
	NguoiDungDAO ndDao;
	
	@Autowired
	HttpServletRequest request;
	
	@GetMapping("/QuanLy")
	public String quanLyIndex() {
		return "QuanLy/QuanLyIndex";
	}
	
	@GetMapping("/QuanLy/ThongKe")
	public String quanLyThongKe(Model model) {
		session.set("viecLam", "ThongKe");
		int soLuongNd = Math.toIntExact(ndDao.count()); //chuyển từ long sang int
		int soLuongSp = Math.toIntExact(spDao.count()); //chuyển từ long sang int
		int soLuongDh = Math.toIntExact(dhDao.count()); //chuyển từ long sang int
		model.addAttribute("soLuongNd",String.valueOf(soLuongNd));
		model.addAttribute("soLuongSp",String.valueOf(soLuongSp));
		model.addAttribute("soLuongDh",String.valueOf(soLuongDh));
		// Kiểm tra nếu đây là yêu cầu AJAX
	    if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
	        return "QuanLy/Layout/ThongKe :: content";
	    }
	    return "QuanLy/QuanLyIndex";
	}
	
	@GetMapping("/QuanLy/QuanLyDonHang")
	public String quanLyDonHang(Model model) {
		session.set("viecLam", "QuanLyDonHang");
		List<DonHang> listDh = dhDao.findAll();
		model.addAttribute("listDh",listDh);
		
		// Kiểm tra nếu đây là yêu cầu AJAX
	    if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
	        return "QuanLy/Layout/QuanLyDonHang :: content";
	    }
	    
	    return "QuanLy/QuanLyIndex";
	}
	
	@GetMapping("/QuanLy/QuanLyNguoiDung")
	public String quanLyNguoiDung(Model model) {
		session.set("vietLam", "QuanLyNguoiDung");
		List<NguoiDung> listNd = ndDao.findAll();
		model.addAttribute("listNd",listNd);
		
		//Kiểm tra nếu là yêu cầu AJAX
		if("XMLHttpRequest".equals(request.getHeader("X-Requested-with"))) {
			return "QuanLy/layout/QuanLyNguoiDung :: content";
		}
		
		return "QuanLy/QuanLyIndex";
	}
	
	
	@GetMapping("/QuanLy/QuanLySanPham")
	public String quanLySanPham(Model model) {
		session.set("viecLam", "QuanLySanPham");
		List<SanPham> listSp = spDao.findAll();
		model.addAttribute("listSp",listSp);
		
		// Kiểm tra nếu đây là yêu cầu AJAX
	    if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
	        return "QuanLy/Layout/QuanLySanPham :: content";
	    }
	    
		return "QuanLy/QuanLyIndex";
	}
	
}
