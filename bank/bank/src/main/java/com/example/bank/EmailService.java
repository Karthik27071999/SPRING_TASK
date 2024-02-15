package com.example.bank;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.activation.DataSource;
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
	 
	 public void sendEmailwithattachment(String email, ByteArrayInputStream pdfReport, String filename) throws MessagingException, IOException {
	        MimeMessage message = mail.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        try {
	        
	            String contentType = "application/pdf";
	            byte[] pdfBytes = IOUtils.toByteArray(pdfReport);
	            ByteArrayResource resource = new ByteArrayResource(pdfBytes);
	            helper.setTo(email);
	            helper.setSubject("TRANSACTION REPORT");
	            helper.setText("AS PER YOUR REQUEST FIND THE BELOW ATTACHMENT FOR TRANSACTION DETAILS");
	            helper.addAttachment(filename, resource, contentType);

	            // Send the email
	            mail.send(message);
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	 }}