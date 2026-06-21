package com.zetheta.notificationmodel;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notification {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String eventType;
	private String message;
	private String channel;
	private String status;
	private LocalDate sentAt;
	private int retryCount;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getEventType() {
		return eventType;
	}
	public int getRetryCount() {
		return retryCount;
	}
	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getSentAt() {
		return sentAt;
	}
	public void setSentAt(LocalDate sentAt) {
		this.sentAt = sentAt;
	}
	
}
