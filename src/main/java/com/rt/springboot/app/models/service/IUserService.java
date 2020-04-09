package com.rt.springboot.app.models.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.rt.springboot.app.models.entity.User;

public interface IUserService extends UserDetailsService {

	User findByUsername(String username);
	
	User save(User registration);
	
}
