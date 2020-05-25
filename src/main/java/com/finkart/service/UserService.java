package com.finkart.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.finkart.entity.User;
import com.finkart.exception.ErrorResponse;
import com.finkart.exception.DataNotFoundException;
import com.finkart.repository.UserRepository;
import com.finkart.util.Constants;

/**
 * @author PRASHANT
 * 
 *         The Class UserService.
 */
@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getUserList() {
		return userRepository.findAll();
	}

	public User createUser(User cust) {
		return userRepository.save(cust);
	}

	public List<User> bulkCreateUser(List<User> custList) {
		return userRepository.saveAll(custList);
	}

	public User getUser(long id) {
		//long userId= getUserInfo();
		return userRepository.getOne(id);
	}

	public User updateUser(User cust) {
		return userRepository.save(cust);
	}

	public User partialUpdate(Map<Object, Object> fields, long id) {
		
		User user = userRepository.findById(id).orElseThrow(() -> new DataNotFoundException(
				new ErrorResponse("User not found", Constants.DATA_NOT_FOUND)));
		System.out.println("user: "+user);
		
		fields.forEach((k, v) -> {
			Field field = ReflectionUtils.findField(User.class, (String)k);
			field.setAccessible(true);
			ReflectionUtils.setField(field, user, v);
			
		});
		
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}
	
	private long getUserInfo() {
		long userId = 1;
		return userId;
	}
}
