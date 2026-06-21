package com.zetheta.notificationservice;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zetheta.emailservice.EmailService;
import com.zetheta.notificationmodel.Notification;
import com.zetheta.notificationrepo.NotificationRepository;
import com.zetheta.smsservice.SmsService;
import com.zetheta.whatsappservice.WhatsappService;

@Service
public class NotificationService {
	private NotificationRepository repo;
	private EmailService email;
	private SmsService sms;
	private WhatsappService whatsapp;
	
	
	
	public NotificationService(NotificationRepository repo,EmailService email,SmsService sms,WhatsappService whatsapp) {
		this.repo=repo;
		this.email=email;
		this.sms=sms;
		this.whatsapp=whatsapp;
		
	}
    
	public void addNotification(Notification notify) {
		
		notify.setStatus("Pending");
		
		repo.save(notify);
	}
   public void processNotification() {
    	List<Notification> notify=repo.findByStatus("Pending");
    	for(Notification n:notify ) {
    		
    		n.setRetryCount(0);
    		repo.save(n);
    		String channel=n.getChannel();
    		try {
    			if(channel.equalsIgnoreCase("email")) {
    				n.setSentAt(LocalDate.now());
    	    		email.sendEmail("sivabagyam63@gmail.com",n.getEventType(), n.getMessage());
    	    		n.setStatus("sent");
    	    		}
    	    		else if(channel.equalsIgnoreCase("sms")) {
    	    			n.setSentAt(LocalDate.now());
    	    			sms.sendSMS();
    	    			n.setStatus("sent");
    	    		}
    	    		else if(channel.equalsIgnoreCase("whatsapp")) {
    	    			n.setSentAt(LocalDate.now());
    	    			whatsapp.sendWhatsapp();
    	    			n.setStatus("sent");
    	    		}
    	    		
    		}
    		catch(Exception e) {
    			n.setRetryCount(n.getRetryCount()+1);
    			if(n.getRetryCount()>=3) {
    				n.setStatus("failed");
    			}
    			else {
    				n.setStatus("pending");
    			}
    		}
    	}
   
    }

   public Optional<Notification> getNotification(long id) {
	
	   return repo.findById(id);
   }
	
}
