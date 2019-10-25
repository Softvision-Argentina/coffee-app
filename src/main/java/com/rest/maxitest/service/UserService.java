package com.rest.maxitest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.maxitest.model.User;

@Service
public interface UserService {
	
	public List<User> getUsers();
	
	public User getUser(int userId);
	
	public List<User> getUsersByRole(String role);
	
	public User addUser(User newUser);
	
	public User updateUser(int userId, User Ouser);
	
	public void deleteUser(int userId);
	
	public List<User> pruebaQueryManual(String name, int numId);
	
	public List<User> getByRole(String role);

}
