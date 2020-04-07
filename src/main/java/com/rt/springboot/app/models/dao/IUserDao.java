package com.rt.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.rt.springboot.app.models.entity.User;

public interface IUserDao extends CrudRepository<User, Long>{

	public User findByUsername(String username);
	
}
