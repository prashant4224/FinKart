package com.finkart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Unauthorized")
public class UnauthorizedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5347317250438462979L;

	private ApiResponse apiResponse;
	
	public UnauthorizedException(ApiResponse apiResponse) {
		this.apiResponse = apiResponse;
	}
	
	public ApiResponse getApiResponse() {
		return apiResponse;
	}
	
}
