package com.group4.service.imp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.group4.entity.MailModel;
import com.group4.service.MailerService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailerServiceImp implements MailerService{

	@Autowired
	JavaMailSender sender;
	
	List<MimeMessage> queue = new ArrayList<>();
	
	@Override
	public void push(String to, String subject, String body) {
		MailModel mail = new MailModel(to, subject, body);
		this.push(mail);
	}

	@Override
	public void push(MailModel mail) {
		MimeMessage message = sender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
			helper.setFrom(mail.getFrom());
			helper.setTo(mail.getTo());
			helper.setSubject(mail.getSubject());
			helper.setText(mail.getBody(),true);
			helper.setReplyTo(mail.getFrom());
			for(String email:mail.getCc()) {
				helper.addCc(email);
			}
			for(String email:mail.getBcc()) {
				helper.addBcc(email);
			}
			for(File file: mail.getFiles()) {
				helper.addAttachment(file.getName(), file);
			}
			
			//Thêm mail vào hàng chờ
			queue.add(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	@Scheduled(fixedDelay = 1000)
	public void run() {
		if (queue.isEmpty()) {
	        return; // Dừng nếu hàng chờ trống
	    }
		
		int success = 0;
		int error = 0;
		while(!queue.isEmpty()) {
			MimeMessage message = queue.remove(0);
			try {
				sender.send(message);
				success++;
			} catch (Exception e) {
				error++;
				e.printStackTrace();
			}
		}
		
		System.out.println("Send: "+success);
		System.out.println("Error: "+error);
	}

}
