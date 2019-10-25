package com.rest.maxitest.dao;

import java.util.List;

import com.rest.maxitest.model.User;

public interface UserDao {

	public List<User> getAllUsers();
	
	public User getUserById(int id);
	
	public List<User> getUsersByRole(String role);
	
	public User addUser(User user);
	
	public User updateUser(User user);
	
	public void deleteUser(User user);
}
