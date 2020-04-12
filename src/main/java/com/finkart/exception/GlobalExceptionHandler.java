package com.finkart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = DataNotFoundException.class)
	public ResponseEntity<ApiResponse> handleDataNotFoundException(DataNotFoundException ex) {
		ApiResponse resp = ex.getApiResponse();
		return new ResponseEntity<ApiResponse>(new ApiResponse(resp.getMessage(), resp.getStstusCode()), HttpStatus.OK);
	}

	@ExceptionHandler(value = NameNotFoundException.class)
	public ResponseEntity<ApiResponse> handleNameNotFoundException(NameNotFoundException ex) {
		ApiResponse resp = ex.getApiResponse();
		return new ResponseEntity<ApiResponse>(new ApiResponse(resp.getMessage(), resp.getStstusCode()), HttpStatus.OK);
	}

	@ExceptionHandler(value = UnauthorizedException.class)
	public ResponseEntity<ApiResponse> handleUnauthorizedException(UnauthorizedException ex) {
		ApiResponse resp = ex.getApiResponse();
		return new ResponseEntity<ApiResponse>(new ApiResponse(resp.getMessage(), resp.getStstusCode()), HttpStatus.OK);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ApiResponse> handleException(Exception ex) {
		return new ResponseEntity<ApiResponse>(new ApiResponse("Input data Invalid", "000"), HttpStatus.OK);
	}
}
