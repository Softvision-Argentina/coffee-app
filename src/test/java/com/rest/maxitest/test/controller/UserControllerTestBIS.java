package com.rest.maxitest.test.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import java.util.ArrayList;
import java.util.List;

import com.rest.maxitest.config.AppConfig;
import com.rest.maxitest.model.User;
import com.rest.maxitest.service.UserService;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK, classes={AppConfig.class})
public class UserControllerTestBIS {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private UserService userServiceMock;
	
	@Before
	public void setUp() {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void getUserTest() throws Exception{
		
		User user = new User(1,"testo",123,"tester");
		User user2 = new User(2,"testa",456,"noTester");
		
		List<User> users = new ArrayList<>();
		users.add(user); users.add(user2);
		
		when(userServiceMock.getUser(1)).thenReturn(user);
		
		mockMvc.perform(get("/users/1") 
		           .accept(MediaType.APPLICATION_JSON))
		           .andExpect(status().isOk())
		           .andExpect(content().contentType(MediaType.APPLICATION_JSON))
		           .andExpect(jsonPath("$.id").value(user.getId()))
		           .andExpect(jsonPath("$.name").value(user.getName()))
		           .andExpect(jsonPath("$.numberId").value(user.getNumberId()))
				   .andExpect(jsonPath("$.role").value(user.getRole()));
		
	}

}
