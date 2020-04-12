package com.finkart.service;

import com.finkart.entity.User;

public interface IAuthenticationService {

	User authenticate(String token);
}
