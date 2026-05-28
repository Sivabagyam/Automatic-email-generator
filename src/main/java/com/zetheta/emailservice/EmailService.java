package com.zetheta.emailservice;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Service
public class EmailService {
	private JavaMailSender mailsender;
	public EmailService(JavaMailSender mailsender) {
		this.mailsender=mailsender;
	}
   public void sendEmail(String to,String subject,String text) {
	   MimeMessage message=mailsender.createMimeMessage();
	
	try {
		   MimeMessageHelper helper=new MimeMessageHelper(message,true);
		   helper.setTo(to);
		   helper.setSubject(subject);
		   try(var inputStream=EmailService.class.getResourceAsStream("/templates/html-content/htmlcontent.html")){
		   String htmlcontent=new String( inputStream.readAllBytes());
		   
		   helper.setText(htmlcontent,true);
		   mailsender.send(message);
		 
		   } catch (IOException e) {
			
			e.printStackTrace();
		}
	} catch (MessagingException e) {
		
		System.out.println("Email sending failed");
	}
	   
	  
   }
}
