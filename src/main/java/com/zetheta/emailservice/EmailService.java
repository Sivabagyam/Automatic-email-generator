package com.zetheta.emailservice;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailService {
	private JavaMailSender mailsender;
	public EmailService(JavaMailSender mailsender) {
		this.mailsender=mailsender;
	}
   public void sendEmail(String to,String subject,String text) {
	   SimpleMailMessage message=new SimpleMailMessage();
	   message.setTo(to);
	   message.setSubject(subject);
	   message.setText(text);
	   try {
	   mailsender.send(message);//this connects to the smtp
	   System.out.println("Emial being sent");
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
   }
}
