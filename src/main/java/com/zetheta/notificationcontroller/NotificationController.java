package com.zetheta.notificationcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zetheta.notificationmodel.Notification;
import com.zetheta.notificationservice.NotificationService;

@RestController
@RequestMapping("/email")
public class NotificationController {
	private NotificationService service;
	
	
	public NotificationController(NotificationService service){
		this.service=service;
		
	}
	@PostMapping("/notification")
	public void addNotification(@RequestBody Notification notify) {
		service.addNotification(notify);
	}
	
}

