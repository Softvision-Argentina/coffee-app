//package com.rest.maxitest.dao;
//
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.springframework.stereotype.Repository;
//
//import com.rest.maxitest.model.User;
//import com.rest.maxitest.repository.UserJpaRepository;
//
//@Repository
//public class UserDaoImpl implements UserDao {
//	
//	UserJpaRepository userJpaRepository;
//
//	@Override
//	@Transactional
//	public List<User> getAllUsers() {
//		return userJpaRepository.findAll();
//	}
//
//	@Override
//	@Transactional
//	public User getUserById(int id) {
//		return userJpaRepository.findById(id);
//	}
//
//	@Override
//	@Transactional
//	public List<User> getUsersByRole(String role) {
//		return userJpaRepository.findByRole(role);
//	}
//	
//	@Override
//	@Transactional
//	public User addUser(User user) {
//		return userJpaRepository.save(user);
//	}
//
//	@Override
//	@Transactional
//	public User updateUser(User user) {
//		return userJpaRepository.save(user);
//	}
//
//	@Override
//	@Transactional
//	public void deleteUser(User user) {
//		userJpaRepository.delete(user);
//
//	}
//
//	@Transactional
//	public List<User> getUserByNameAndNumberId(String name, int numberId){
//		return userJpaRepository.findByNameAndNumberId(name, numberId);
//	}
//
//}
