package com.group4.entity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailModel {
	
	private String from = "Cửa hàng điện máy HTV <cuahangdienmayhtv@gmail.com>";
	
	private String to;
	
	private String subject;
	
	private String body;
	
	private List<String> cc = new ArrayList<>();
	
	private List<String> bcc = new ArrayList<>();
	
	private List<File> files = new ArrayList<>();
	
	public MailModel(String to, String subject, String body) {
		super();
		this.to = to;
		this.subject = subject;
		this.body = body;
	}
}
