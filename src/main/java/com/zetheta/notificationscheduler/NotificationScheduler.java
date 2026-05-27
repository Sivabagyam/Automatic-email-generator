package com.zetheta.notificationscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zetheta.notificationservice.NotificationService;

@Component
public class NotificationScheduler {
	private NotificationService service; 
	public NotificationScheduler(NotificationService service)
	{
		this.service=service;
	}
	@Scheduled(fixedRate=10000)
	public void runscheduler() {
		service.processNotification();
		
	}
}
