package com.zetheta.userservice;

import org.springframework.stereotype.Service;

import com.zetheta.usermodel.Users;
import com.zetheta.userrepo.UserRepository;
@Service
public class UserService {
	private UserRepository repo;
	public UserService(UserRepository repo) {
		this.repo=repo;
	}

	public void login(Users user) {
		
		repo.save(user);
	}

}
