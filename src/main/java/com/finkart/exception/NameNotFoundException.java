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
	
	private ApiResponse apiResponse;
	
	public NameNotFoundException(ApiResponse apiResponse) {
		super();
		this.apiResponse=apiResponse;
	}
	
	public ApiResponse getApiResponse() {
		return apiResponse;
	}

	
}
