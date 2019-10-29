package com.maxi.calendar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.maxi.calendar.model.User;
import com.maxi.calendar.repository.UserRepository;

@Service
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
		User newUser = new User(name, role);
		return userRepository.save(newUser);
	}

	@Override
	public void editUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);

	}

}
