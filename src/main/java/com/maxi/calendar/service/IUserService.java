package com.maxi.calendar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maxi.calendar.model.User;

@Service
public interface IUserService {
	
	public List<User> getAllUsers();
	
	public User getUser(int id);
	
	public User createUser(User newUser);
	
	public void editUser(User user);
	
	public void deleteUser(int id);
	

}
