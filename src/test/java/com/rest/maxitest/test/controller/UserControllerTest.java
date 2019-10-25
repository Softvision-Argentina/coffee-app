package com.rest.maxitest.test.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rest.maxitest.controller.UserController;
import com.rest.maxitest.model.User;
import com.rest.maxitest.service.UserService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class UserControllerTest {
	
	@InjectMocks
	UserController userController = new UserController();
	
	@Mock
	UserService userService;

	@Test
	void testGetUsers() {
		
		User user = new User(1,"testo",123,"tester");
		User user2 = new User(2,"testa",456,"noTester");
		
		List<User> users = new ArrayList<>();
		users.add(user); users.add(user2);
		
		when(userService.getUsers()).thenReturn(users);
		
		//when
		List<User> result = (List<User>) userController.getUsers();
		
		//then
		assertThat(result.size()).isEqualTo(2);
		
		assertThat(result.get(0).getName()).isEqualTo(user.getName());
		
		assertThat(result.get(1).getRole()).isEqualTo(user2.getRole());

	}

}
