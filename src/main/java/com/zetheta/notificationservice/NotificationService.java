package com.zetheta.notificationservice;

import java.time.LocalDate;
import java.util.List;


import org.springframework.stereotype.Service;

import com.zetheta.emailservice.EmailService;
import com.zetheta.notificationmodel.Notification;
import com.zetheta.notificationrepo.NotificationRepository;

@Service
public class NotificationService {
	private NotificationRepository repo;
	private EmailService service;
	
	
	
	
	public NotificationService(NotificationRepository repo,EmailService service) {
		this.repo=repo;
		this.service=service;
		
	}
    
	public void addNotification(Notification notify) {
		
		notify.setStatus("Pending");
		notify.setCreatedAt(LocalDate.now());
		repo.save(notify);
	}
   public void processNotification() {
    	List<Notification> notify=repo.findByStatus("Pending");
    	for(Notification n:notify ) {
    		n.setStatus("sent");
    		repo.save(n);
    		
    		service.sendEmail("sivabagyam63@gmail.com",n.getEventType(), n.getMessage());
    	
    	}
   
    }
	
}
