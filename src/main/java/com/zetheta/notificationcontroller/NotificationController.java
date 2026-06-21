package com.zetheta.notificationcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zetheta.notificationmodel.Notification;
import com.zetheta.notificationservice.NotificationService;

import jakarta.servlet.http.HttpServletRequest;

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
	@GetMapping("/notification/{id}")
	public Optional<Notification> getNotification(@PathVariable long id) {
		return  service.getNotification(id);
	}
	
}

