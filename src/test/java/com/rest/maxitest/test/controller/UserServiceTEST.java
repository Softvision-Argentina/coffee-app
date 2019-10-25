package com.rest.maxitest.test.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.rest.maxitest.model.User;
import com.rest.maxitest.repository.UserJpaRepository;
import com.rest.maxitest.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTEST {
	
	@Mock
	UserJpaRepository userJpaRepository;
	
	@InjectMocks
	UserServiceImpl userService;
	
	@Test
	public void getUserOnServTest() {
		User user = new User(1,"testServi",123,"testse");
		
		when(userService.getUser(anyInt())).thenReturn(user);
		
		User userGot = userService.getUser(user.getId());
		
		assertThat(userGot.getName()).isSameAs(user.getName());

	}

}
