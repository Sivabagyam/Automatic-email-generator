package com.zetheta.usercontroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zetheta.usermodel.Users;
import com.zetheta.userservice.UserService;

@RestController
public class UserController {
	private UserService service;
	public UserController(UserService service) {
		this.service=service;
	}
	@PostMapping("/signup")
	public void login(@RequestBody Users user) {
		
		service.login(user);
	}

}
