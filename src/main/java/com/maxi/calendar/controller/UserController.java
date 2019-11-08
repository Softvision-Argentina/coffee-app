package com.maxi.calendar.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.calendar.model.User;
import com.maxi.calendar.service.IUserService;
import com.maxi.calendar.service.UserServiceImpl;
import com.maxi.calendar.utils.Roles;

@RestController
@RequestMapping("/users")
public class UserController {
	
	//@Autowired
	IUserService userService;	

	UserController(UserServiceImpl userService){
		this.userService=userService;
	}
	
	@GetMapping ("/")
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
	
	@PostMapping("/add")
	public ResponseEntity<?> addUser(@RequestBody User newUser) {
		
		User user = userService.createUser(newUser);
		
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> modifyUser(@RequestBody User uUser, @PathVariable int id) {
		
		String uName = uUser.getName();
		Roles uRole = uUser.getRole();
		
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

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eraseUser(@PathVariable int id) {
		
		User user = userService.getUser(id); 
		if (user != null) {
			userService.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
}
