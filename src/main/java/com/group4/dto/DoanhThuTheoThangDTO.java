package com.group4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoanhThuTheoThangDTO {
	private int thang;
	
	private int nam;
	
	private double doanhThu;
}
