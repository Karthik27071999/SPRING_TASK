package com.example.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender mail;
	
	 public void sendEmail(String to, String subject, String text) {
	        MimeMessage message = mail.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message);
	        try {
	            helper.setTo(to);
	            helper.setSubject(subject);
	            helper.setText(text);
	            mail.send(message);
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    }

}
