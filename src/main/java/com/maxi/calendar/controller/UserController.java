package com.maxi.calendar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.calendar.model.User;
import com.maxi.calendar.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	IUserService userService;	
	
	@RequestMapping (value="/", method=RequestMethod.GET)
	public ResponseEntity<?> getAll(){
		
		List<User> users = userService.getAllUsers();
		
		if (users.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable int id) {
		
		User user = userService.getUser(id); 
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<?> addUser(@RequestBody User newUser) {
		
		User user = userService.createUser(newUser);
		
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<?> modifyUser(@RequestBody User uUser, @PathVariable int id) {
		
		String uName = uUser.getName();
		String uRole = uUser.getRole();
		
		User user = userService.getUser(id);		
		if (user != null) {
			if(!uName.equals(user.getName())) {
				user.setName(uName);
			}
			if(!uRole.equals(user.getRole())) {
				user.setRole(uRole);
			}			
			userService.editUser(user);			
			return new ResponseEntity<>(user, HttpStatus.OK);
		}		
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> eraseUser(@PathVariable int id) {
		
		User user = userService.getUser(id); 
		if (user != null) {
			userService.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
}
