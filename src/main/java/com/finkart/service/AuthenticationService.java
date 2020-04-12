package com.finkart.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import com.finkart.entity.User;
import com.finkart.exception.ApiResponse;
import com.finkart.exception.UnauthorizedException;
import com.finkart.repository.UserRepository;
import com.finkart.util.Constants;

@Service
public class AuthenticationService implements IAuthenticationService {

	private UserRepository userRepository;

	@Override
	public User authenticate(String token) {

		try {
			String[] split = token.split(" ");
			String type = split[0];
			String credential = split[1];

			if ("Basic".equalsIgnoreCase(type)) {
				String decoded = new String(Base64Utils.decodeFromString(credential));
				String[] usernameAndPassword = decoded.split(":");

				User user = userRepository.findByUsernameAndPassword(usernameAndPassword[0], usernameAndPassword[1]);
				if (user == null) {
					throw new UnauthorizedException(new ApiResponse("Invalid credentials", Constants.UNAUTHORIZED));
				} else {
					return user;
				}
			} else {
				throw new UnauthorizedException(new ApiResponse("Invalid credentials", Constants.UNAUTHORIZED));
			}
		} catch (IllegalArgumentException | ArrayIndexOutOfBoundsException ex) {
			throw new UnauthorizedException(new ApiResponse("Invalid credentials", Constants.UNAUTHORIZED));
		}
	}
}
