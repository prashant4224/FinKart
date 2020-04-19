package com.finkart.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.finkart.entity.PartialData;
import com.finkart.entity.User;
import com.finkart.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;
	@Mock
	Map<Object, Object> partiData;
	
	@Test
	public void allUsersTest() {
		User user = spy(User.class);
		List<User> userList = new ArrayList<>();
		userList.add(user);
		when(userService.getUserList()).thenReturn(userList);
		ResponseEntity<List<User>> uList = userController.allUsers();
		
		assertEquals(userList, uList.getBody());
	}
	
	@Test
	public void createUserTest() {
		User user = spy(User.class);
		when(userService.createUser(user)).thenReturn(user);
		
		ResponseEntity<User> us = userController.createUser(user);
		assertEquals(user, us.getBody());
		
	}
	
	@Test
	public void bulkCreateUserTest() {
		User user = spy(User.class);
		List<User> userList = new ArrayList<>();
		userList.add(user);
		when(userService.bulkCreateUser(userList)).thenReturn(userList);
		
		ResponseEntity<List<User>> uList = userController.bulkCreateUser(userList);
		
		assertEquals(userList, uList.getBody());
		
	}
	
	@Test
	public void getUserTest() {
		User user = spy(User.class);
		when(userService.getUser(2)).thenReturn(user);
		
		ResponseEntity<User> us = userController.getUser(2);
		assertEquals(user, us.getBody());		
	}
	
	@Test
	public void updateUserTest() {
		User user = spy(User.class);
		when(userService.updateUser(user)).thenReturn(user);
		
		ResponseEntity<User> us = userController.updateUser(user);
		assertEquals(user, us.getBody());	
	}
	
	@Test
	public void partialUpdateUserTest() throws Exception {
		//Map<Object, Object> partiData;// = spy(PartialData.class);
		User user = spy(User.class);
		List<User> userList = new ArrayList<>();
		userList.add(user);
		when(userService.partialUpdate(partiData, 2)).thenReturn(user);
		
		ResponseEntity<User> us = userController.partialUpdateUser(partiData, 2);
		assertEquals(user, us.getBody());
	}
	
	@Test
	public void deleteUserTest() {
		
		doNothing().when(userService).deleteUser(1);
		
		userController.deleteUser(1);	
	}
	
}
