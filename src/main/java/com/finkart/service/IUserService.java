package com.finkart.service;

import java.util.List;
import java.util.Map;

import com.finkart.entity.User;

/**
 * @author PRASHANT
 * 
 * The Interface IUserService.
 */
public interface IUserService {
	
	public List<User> getUserList();
	
	public User createUser(User cust);
	public List<User> bulkCreateUser(List<User> custList);

	public User updateUser(User cust);
	
	public User getUser(long id);
	
	public User partialUpdate(Map<Object, Object> fields, long id);
	
	public void deleteUser(long id);
	

}
