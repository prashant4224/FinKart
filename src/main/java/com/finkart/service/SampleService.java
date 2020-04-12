package com.finkart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.finkart.entity.User;

@Service
public class SampleService {

	
	public List<User> userDetails(){
		
		return userList();
	}
	
	
	private List<User> userList(){
		List<User> userList = new ArrayList<User>();
		User user = new User();
		user.setId(1l);
		user.setFirstName("test");
		userList.add(user);
		return userList;
	}
}
