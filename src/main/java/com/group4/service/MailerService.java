package com.group4.service;

import com.group4.entity.MailModel;

public interface MailerService {
	
	public void push(String to, String subject, String body);
	
	public void push(MailModel mail);
	
	public void run();
	
}
