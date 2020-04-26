package com.finkart.exception;

/**
 * @author PRASHANT
 * 
 * The Class NameNotFoundException.
 */
public class NameNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1538705864173056513L;
	
	private ErrorResponse errorResponse;
	
	public NameNotFoundException(ErrorResponse errorResponse) {
		super();
		this.errorResponse=errorResponse;
	}
	
	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	
}
