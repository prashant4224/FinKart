package com.finkart.exception;

/**
 * @author PRASHANT
 * 
 * The Class DataNotFoundException.
 */
public class DataNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1538705864173056513L;
	
	private ErrorResponse errorResponse;
	
	public DataNotFoundException(ErrorResponse errorResponse) {
		super();
		this.errorResponse=errorResponse;
	}
	
	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	
}
