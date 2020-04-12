package com.finkart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finkart.entity.PartialData;
import com.finkart.entity.User;
import com.finkart.exception.ApiResponse;
import com.finkart.exception.DataNotFoundException;
import com.finkart.exception.NameNotFoundException;
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
	private UserRepository UserRepository;

	public List<User> getUserList() {
		return UserRepository.findAll();
	}

	public User createUser(User cust) {
		return UserRepository.save(cust);
	}

	public List<User> bulkCreateUser(List<User> custList) {
		return UserRepository.saveAll(custList);
	}

	public User getUser(long id) {
		long userId= getUserInfo();
		return UserRepository.getOne(userId);
	}

	public User updateUser(User cust) {
		return UserRepository.save(cust);
	}

	public User partialUpdate(PartialData cust, long id) throws DataNotFoundException, NameNotFoundException {
		User User = UserRepository.findById(id).orElseThrow(() -> new DataNotFoundException(
				new ApiResponse("User not found", Constants.DATA_NOT_FOUND)));
		if (cust.getUpdates().containsKey("firstName")) {
			User.setFirstName((String) cust.getUpdates().get("firstName"));
		} else {
			throw new NameNotFoundException(new ApiResponse("Name is not valid", Constants.DATA_NOT_FOUND));
		}
		if (cust.getUpdates().containsKey("lastName")) {
			User.setLastName((String) cust.getUpdates().get("lastName"));
		}
		if (cust.getUpdates().containsKey("address1")) {
			User.setAddress1((String) cust.getUpdates().get("address1"));
		}
		if (cust.getUpdates().containsKey("address2")) {
			User.setAddress2((String) cust.getUpdates().get("address2"));
		}
		if (cust.getUpdates().containsKey("address3")) {
			User.setAddress3((String) cust.getUpdates().get("address3"));
		}
		if (cust.getUpdates().containsKey("city")) {
			User.setCity((String) cust.getUpdates().get("city"));
		}
		if (cust.getUpdates().containsKey("state")) {
			User.setState((String) cust.getUpdates().get("state"));
		}
		if (cust.getUpdates().containsKey("pinCode")) {
			User.setPinCode((String) cust.getUpdates().get("pinCode"));
		}
		return UserRepository.save(User);
	}

	@Override
	public void deleteUser(long id) {
		UserRepository.deleteById(id);
	}
	
	private long getUserInfo() {
		long userId = 1;
		return userId;
	}
}
