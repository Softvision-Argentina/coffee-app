package com.maxi.calendar.service;

import java.util.ArrayList;
import java.util.List;

import com.maxi.calendar.model.User;
import com.maxi.calendar.repository.UserRepository;

public class UserServiceImpl implements IUserService {
	
	UserRepository userRepository;
	
	List<User> users = new ArrayList<User>();

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String name) {
		return userRepository.findByName(name);
	}

	@Override
	public User createUser(String name, String role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editUser(String name) {
		User user = userRepository.findByName(name);
		userRepository.save(user);
	}

	@Override
	public void deleteUser(String name) {
		User user = userRepository.findByName(name);
		userRepository.delete(user);

	}

}
