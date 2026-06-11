package com.zetheta.usermodel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String userName;
private String userPassword;
private String userEmail;
private long userMobile;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserPassword() {
	return userPassword;
}
public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}
public String getUserEmail() {
	return userEmail;
}
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}
public long getUserMobile() {
	return userMobile;
}
public void setUserMobile(long userMobile) {
	this.userMobile = userMobile;
}


}
