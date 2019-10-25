package com.rest.maxitest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.maxitest.model.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {

	@Transactional
	public User findById(int id);
	
	@Transactional
	public List<User> findByRole(String role);
	
	@Query(value = "SELECT * FROM users u where u.name = ?1 AND u.number_id = ?2", nativeQuery=true)
	@Transactional
	public List <User> pruebaQueryNombreYNumero(@Param("name")String name, @Param("number_id")int numberId);
	
	
	
}
