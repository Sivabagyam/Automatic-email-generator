package com.zetheta.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zetheta.usermodel.UserPrincipal;
import com.zetheta.usermodel.Users;
import com.zetheta.userrepo.UserRepository;
@Service
public class MyUserDetailsService implements UserDetailsService {
@Autowired
private UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("This is been called");
		Users user=repo.findByUserName(username);
		if(user==null) {
			throw  new UsernameNotFoundException("User not found");
		}
		return new UserPrincipal(user);
	}

}
