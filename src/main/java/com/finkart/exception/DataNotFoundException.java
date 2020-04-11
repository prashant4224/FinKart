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
	
	private ApiResponse apiResponse;
	
	public DataNotFoundException(ApiResponse apiResponse) {
		super();
		this.apiResponse=apiResponse;
	}
	
	public ApiResponse getApiResponse() {
		return apiResponse;
	}

	
}
