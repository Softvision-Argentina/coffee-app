package com.rest.maxitest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.maxitest.model.User;
import com.rest.maxitest.repository.UserJpaRepository;

@Service
@Transactional 
public class UserServiceImpl implements UserService{
	
	private List<User> usersList = null;
		
	@Autowired
	private UserJpaRepository userJpaRepository;
	
	public List<User> getUsers() {
		
		return userJpaRepository.findAll();
	}
	
	public User getUser(int userId) {
		
		return userJpaRepository.findById(userId);				

	}
	
	@Override
	public List<User> getUsersByRole(String role) {
		return userJpaRepository.findByRole(role);
	}
	
	public User addUser(User newUser) {
		
		return userJpaRepository.save(newUser);
		
	}
	
	public User updateUser(int userId, User Ouser) {
		
		for(User user : usersList) {
			if (user.getId()==userId) {
				user.setName(Ouser.getName());
				user.setNumberId(Ouser.getNumberId());
				user.setRole(Ouser.getRole());
			}
			
			return userJpaRepository.save(user);
		}
		
		return null;
	}
	
	public void deleteUser(int id) {
		userJpaRepository.deleteById(id);
	}
	
	public List<User> pruebaQueryManual(String name, int numId) {
		return userJpaRepository.pruebaQueryNombreYNumero(name, numId);
	}

	public List<User> getByRole(String role) {
		return userJpaRepository.findByRole(role);
	}

}
