package com.group4.controller.rest;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group4.dao.DonHangDAO;
import com.group4.entity.DonHang;
import com.group4.service.DonHangService;
import com.group4.service.MailerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/DonHang")
public class DonHangRestController {
	
	@Autowired
	DonHangService dhService;
	
	@Autowired
	MailerService mailService;
	
	@GetMapping()
	public ResponseEntity<Collection<DonHang>> restGetAllDh(){
		List<DonHang> listDh = dhService.findAll();
		if(listDh.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(listDh);
	}
	
	@GetMapping("SoLuong")
	public ResponseEntity<Integer> restGetSoLuongDh(){
		int soLuong = dhService.count();
		return ResponseEntity.ok(soLuong);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<DonHang> restGetDhById(@PathVariable("id") Integer id){
		Optional<DonHang> dh =dhService.findById(id);
		if(dh.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dh.get());
	}
	
	@GetMapping("/TrangThai/{x}")
	public ResponseEntity<Collection<DonHang>> restGetDhByTrangThai(@PathVariable("x") String x){
		List<DonHang> listDh = dhService.findAllByTrangThai(x);
		if(listDh.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(listDh);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<DonHang> restPutDh(@PathVariable("id") Integer id, @RequestBody DonHang dh){
		if(!dhService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		dhService.save(dh);
		//Gửi mail
		String body = "Kính chào khách hàng "+dh.getNguoiDung().getHoTen()+".\n\n"
						+ "Quý khách có 1 đơn hàng có mã "+dh.getMaDonHang()+", địa chỉ nhận hàng là "+dh.getDiaChiGiao()+".\n\n"
						+ "Hiện đơn hàng đang trong trạng thái "+dh.getTrangThai()+".\n\n"
						+ "Cảm ơn quý khách đã tin tưởng cửa hàng điện máy HTV.\n";
		mailService.push(dh.getNguoiDung().getEmail(),"Cập nhật trạng thái đơn hàng",body);
		return ResponseEntity.ok(dh);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> restDeleteDh(@PathVariable("id") Integer id){
		if(!dhService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		dhService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}
