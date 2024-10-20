package com.group4.util;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ParamUtil {

	@Autowired
	HttpServletRequest req;

	@Autowired
	ServletContext servletContext;

	public String getString(String name, String defaultValue) {
		if (req.getParameter(name) != null) {
			return req.getParameter(name);
		} else {
			return defaultValue;
		}
	}

	public int getInt(String name, int defaultValue) {
		try {
			if (req.getParameter(name) != null) {
				return Integer.parseInt(req.getParameter(name));
			} else {
				return defaultValue;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return defaultValue;
		}
	}

	public double getDouble(String name, double defaultValue) {
		try {
			if (req.getParameter(name) != null) {
				return Double.parseDouble(req.getParameter(name));
			} else {
				return defaultValue;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return defaultValue;
		}
	}

	public boolean getBoolean(String name, boolean defaultValue) {
		try {
			if (req.getParameter(name) != null) {
				return true;
			} else {
				return defaultValue;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return defaultValue;
		}
	}

	public Date getDate(String name, String pattern) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		if (req.getParameter(name) != null) {
			Date date = new Date();
			date = sdf.parse(req.getParameter(name));
			return date;
		} else {
			return null;
		}
	}

	public void saveFile(MultipartFile atach, String path) {
		// Kiểm tra và tạo thư mục photo nếu chưa tồn tại
		File uploadPath = new File(servletContext.getRealPath(path));
		if (!uploadPath.exists()) {
			uploadPath.mkdir();
		}

		// upload hinh
		String fileName = atach.getOriginalFilename();
		File file = new File(uploadPath + "/" + fileName);
		try {
			atach.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}

}
