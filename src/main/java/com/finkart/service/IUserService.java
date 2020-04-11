package com.finkart.service;

import java.util.List;

import com.finkart.entity.PartialData;
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
	
	public User partialUpdate(PartialData cust, long id) throws Exception;
	
	public void deleteUser(long id);
	

}
