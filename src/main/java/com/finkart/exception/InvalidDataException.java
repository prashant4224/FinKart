package com.finkart.exception;

/**
 * @author PRASHANT
 * 
 * The Class InvalidDataException.
 */
public class InvalidDataException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public InvalidDataException(String msg) {
		super();
		this.message=msg;
	}
	
	public String getMessage() {
		return message;
	}

	
}
