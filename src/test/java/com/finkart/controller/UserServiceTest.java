package com.finkart.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.finkart.entity.PartialData;
import com.finkart.entity.User;
import com.finkart.exception.DataNotFoundException;
import com.finkart.exception.NameNotFoundException;
import com.finkart.repository.UserRepository;
import com.finkart.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	
	@InjectMocks
	UserService userService;
	
	@Mock
	UserRepository userRepository;
	
	@Test
	public void allUsersTest() {
		User user = spy(User.class);
		List<User> userList = new ArrayList<>();
		userList.add(user);
		when(userRepository.findAll()).thenReturn(userList);
		List<User> uList = userService.getUserList();
		
		assertEquals(userList, uList);
	}
	
	@Test
	public void createUserTest() {
		User user = spy(User.class);
		when(userRepository.save(user)).thenReturn(user);
		
		User us = userService.createUser(user);
		assertEquals(user, us);
		
	}
	
	@Test
	public void bulkCreateUserTest() {
		User user = spy(User.class);
		List<User> userList = new ArrayList<>();
		userList.add(user);
		when(userRepository.saveAll(userList)).thenReturn(userList);
		
		List<User> uList = userService.bulkCreateUser(userList);
		
		assertEquals(userList, uList);
		
	}
	
	@Test
	public void getUserTest() {
		User user = spy(User.class);
		//PowerMockito.when(userService.ge)
		when(userRepository.getOne(2l)).thenReturn(user);
		
		User us = userService.getUser(2);
		assertEquals(user, us);		
	}
	
	@Test
	public void updateUserTest() {
		User user = spy(User.class);
		when(userRepository.save(user)).thenReturn(user);
		
		User us = userService.updateUser(user);
		assertEquals(user, us);	
	}
	
	@Test
	public void partialUpdateUserTest() throws DataNotFoundException, NameNotFoundException {
		PartialData partiData = spy(PartialData.class);
		User user = spy(User.class);
		Map<String, Object> map = new HashMap<>();
		map.put("id", 1);
		map.put("firstName", "test");
		map.put("lastName", "last");
		map.put("address1", "test");
		map.put("address2", "last");
		map.put("address3", "test");
		map.put("city", "last");
		map.put("state", "test");
		map.put("pinCode", "last");
		
		when(userRepository.findById(1l)).thenReturn(Optional.of(user));
		partiData.setUpdates(map);
		when(userRepository.save(user)).thenReturn(user);
		
		User us = userService.partialUpdate(partiData, 1);
		assertEquals(user, us);
	}
	
	@Test(expected=DataNotFoundException.class)
	public void partialUpdateDataNotFoundExceptionTest() throws DataNotFoundException, NameNotFoundException {
		PartialData partiData = spy(PartialData.class);
		User user = spy(User.class);
		List<User> userList = new ArrayList<>();
		userList.add(user);
		//when(userRepository.save(user)).thenReturn(user);
		
		User us = userService.partialUpdate(partiData, 2);
		assertEquals(user, us);
	}
	
	@Test
	public void deleteUserTest() {
		
		doNothing().when(userRepository).deleteById(1l);
		
		userService.deleteUser(1);	
	}
	
}
