package com.maxi.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maxi.calendar.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
