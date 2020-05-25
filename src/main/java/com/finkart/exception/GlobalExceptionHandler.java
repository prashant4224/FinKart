package com.finkart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = DataNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleDataNotFoundException(DataNotFoundException ex) {
		ErrorResponse resp = ex.getErrorResponse();
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(resp.getMessage(), resp.getStstusCode()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = NameNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNameNotFoundException(NameNotFoundException ex) {
		ErrorResponse resp = ex.getErrorResponse();
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(resp.getMessage(), resp.getStstusCode()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = UnauthorizedException.class)
	public ResponseEntity<ErrorResponse> handleUnauthorizedException(UnauthorizedException ex) {
		ErrorResponse resp = ex.getErrorResponse();
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(resp.getMessage(), resp.getStstusCode()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<ErrorResponse> handleException(RuntimeException ex) {
		ex.getStackTrace();
		return new ResponseEntity<ErrorResponse>(new ErrorResponse("Input data Invalid", "001"), HttpStatus.BAD_REQUEST);
	}
}
