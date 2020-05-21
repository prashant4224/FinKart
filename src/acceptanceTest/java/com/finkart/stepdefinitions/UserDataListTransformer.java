package com.finkart.stepdefinitions;

import com.finkart.entity.User;
import com.google.gson.Gson;

import cucumber.api.Transformer;

public class UserDataListTransformer extends Transformer<User>{

	@Override
	public User transform(String value) {
		//List<User> userList = Arrays.asList((new Gson().fromJson(value, User.class));
		User user = new Gson().fromJson(value, User.class);
		return user;
	}

	
}
