package com.finkart.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return UserRepository.getOne(id);
	}

	public User updateUser(User cust) {
		return UserRepository.save(cust);
	}

	public User partialUpdate(Map<String, Object> cust, Long id) throws DataNotFoundException, NameNotFoundException {
		User User = UserRepository.findById(id).orElseThrow(() -> new DataNotFoundException(
				new ApiResponse("User not found", Constants.DATA_NOT_FOUND)));
		if (cust.containsKey("firstName")) {
			User.setFirstName((String) cust.get("firstName"));
		} else {
			throw new NameNotFoundException(new ApiResponse("Name is not valid", Constants.DATA_NOT_FOUND));
		}
		if (cust.containsKey("lastName")) {
			User.setLastName((String) cust.get("lastName"));
		}
		if (cust.containsKey("address1")) {
			User.setAddress1((String) cust.get("address1"));
		}
		if (cust.containsKey("address2")) {
			User.setAddress2((String) cust.get("address2"));
		}
		if (cust.containsKey("address3")) {
			User.setAddress3((String) cust.get("address3"));
		}
		if (cust.containsKey("city")) {
			User.setCity((String) cust.get("city"));
		}
		if (cust.containsKey("state")) {
			User.setState((String) cust.get("state"));
		}
		if (cust.containsKey("pinCode")) {
			User.setPinCode((String) cust.get("pinCode"));
		}
		return UserRepository.save(User);
	}

	@Override
	public void deleteUser(Long id) {
		UserRepository.deleteById(id);
	}
}
