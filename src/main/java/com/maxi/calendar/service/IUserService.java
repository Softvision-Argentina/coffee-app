package com.maxi.calendar.service;

import org.springframework.stereotype.Service;

import com.maxi.calendar.model.User;

@Service
public interface IUserService {
	
	public User getAllUsers();
	
	public User getUser(String name);
	
	public User createUser(String name, String role);
	
	public void editUser(String name);
	
	public void deleteUser(String name);
	

}
