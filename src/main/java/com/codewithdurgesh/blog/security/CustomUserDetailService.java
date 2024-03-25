package com.codewithdurgesh.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codewithdurgesh.blog.entities.User;
import com.codewithdurgesh.blog.exceptions.ResourceNotFoundException;
import com.codewithdurgesh.blog.repositories.UserRepo;


@Service
public class CustomUserDetailService implements UserDetailsService {

	
	@Autowired
	
	private UserRepo userRepo;
	
	@Override
	public User loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = this.userRepo.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("User","User Id",1));
		return user;
	}

}
