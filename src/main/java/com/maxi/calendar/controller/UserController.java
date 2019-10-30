package com.maxi.calendar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	User user = new User();	
	String printError = "ERROR AL PROCESAR SOLICITUD";
	
	@RequestMapping (value="/all", method=RequestMethod.GET)
	public ResponseEntity<?> getAll(){
		
		List<User> users = userService.getAllUsers();
		
		if (users.isEmpty())
		{
			return new ResponseEntity<>("NO HAY USUARIOS", HttpStatus.OK);
		}
		
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{name}", method=RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable String name) {
		
		user = userService.getUser(name); 
		if (user == null) {
			return new ResponseEntity<>(printError, HttpStatus.OK);
		}

		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/new/{name}/{role}", method=RequestMethod.POST)
	public ResponseEntity<?> addUser(@PathVariable String name,@PathVariable String role) {
		
		user = userService.createUser(name, role);
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/mod/{name}/{role}", method=RequestMethod.PUT)
	public ResponseEntity<?> modifyUser(@PathVariable String name,@PathVariable String role) {
		
		user = userService.getUser(name);		
		if (user != null) {
			if(name.equals(user.getName())) {
				user.setName(name);
			}
			if(role.equals(user.getRole())) {
				user.setRole(role);
			}			
			userService.editUser(user);			
			return new ResponseEntity<>(user, HttpStatus.OK);
		}		
		return new ResponseEntity<>(printError, HttpStatus.OK);
	
	}

	@RequestMapping(value="/d/{name}", method=RequestMethod.DELETE)
	public ResponseEntity<?> eraseUser(@PathVariable String name) {
		
		user = userService.getUser(name); 
		if (user != null) {
			userService.deleteUser(user);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(printError, HttpStatus.OK);
		
	}
}
