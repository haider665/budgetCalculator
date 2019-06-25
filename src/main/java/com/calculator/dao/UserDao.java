package com.calculator.dao;

import com.calculator.entity.User;

public interface UserDao {
	
	public void addUser(User user);
	public User getUser(String name,String password);
	public User getUserById(String id);
	
}
