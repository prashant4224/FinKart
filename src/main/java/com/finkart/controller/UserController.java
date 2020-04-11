package com.finkart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finkart.entity.User;
import com.finkart.service.IUserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author PRASHANT
 * 
 *         The Class UserController.
 */
@RestController
@RequestMapping("/user/v1")
@Slf4j
public class UserController {

	@Autowired
	private IUserService userService;

	/**
	 * All users.
	 *
	 * @return the response entity
	 */
	@GetMapping("/user-list")
	public ResponseEntity<List<User>> allUsers() {
		List<User> userList = userService.getUserList();
		
		log.info("allUsers :: {} ", userList.toString());
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}

	/**
	 * Creates the User.
	 *
	 * @param cust the user
	 * @return the response entity
	 */
	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User us = userService.createUser(user);
		return new ResponseEntity<User>(us, HttpStatus.OK);
	}
	
	@PostMapping(value = "/bulk-create", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
	public ResponseEntity<List<User>> bulkCreateUser(@RequestBody List<User> userList) {
		List<User> usList = userService.bulkCreateUser(userList);
		return new ResponseEntity<List<User>>(usList, HttpStatus.OK);
	}

	@GetMapping(value="/customer/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE, headers="Accept=application/json")
	public ResponseEntity<User> getUser(@PathVariable long id){
		User cust = userService.getUser(id);
		return new ResponseEntity<User>(cust, HttpStatus.OK);
	}
	
	@PutMapping(value="/customer", consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE, headers="Accept=application/json")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		User cust = userService.updateUser(user);
		return new ResponseEntity<User>(cust,HttpStatus.OK);
	}
	
	@PutMapping(value="/customer/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE, headers="Accept=application/json")
	public ResponseEntity<User> partialUpdateUser(@RequestBody Map<String, Object> updates, 
			@PathVariable Long id) throws Exception{
		User user = userService.partialUpdate(updates, id);
		return new ResponseEntity<User>(user,HttpStatus.OK);		
	}
	
	public ResponseEntity<User> deleteUser(@PathVariable Long id){
		userService.deleteUser(id);
		return new ResponseEntity<User>(HttpStatus.OK);
	}

	
}
