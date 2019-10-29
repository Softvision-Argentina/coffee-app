package com.maxi.calendar.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.maxi.calendar.model.User;
import com.maxi.calendar.repository.UserRepository;
import com.maxi.calendar.service.IUserService;

@Controller

public class UserController {
	
	IUserService userService;
	
	User user = new User();
	
	String printError;
	
	public List<User> getAll(){
		
		return userService.getAllUsers();
	}
	
	public User getUser(String name) {
		
		user = userService.getUser(name); 
		if (user != null) {
			return user;
		}
		printError="no existe usuario";
		return printError;
	}
	
	public User addUser(String name, String role) {
		
		return userService.createUser(name, role);
	}
	
	public String modifyUser(String name, String role) {
		
		User user = userService.getUser(name);
		
		if (user.equals(null)) {
			return printError="No existe usuario";
		}
		
		user.setName(name);
		user.setRole(role);
		
		userService.editUser(user);
		
		return "OK";
	}

	public String eraseUser(String name) {
		
		user = userService.getUser(name); 
		if (user != null) {
			userService.deleteUser(user);
			return "OK";
		}
		return printError="No existe usuario";
	}
}
