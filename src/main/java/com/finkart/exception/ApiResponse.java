package com.finkart.exception;

public class ApiResponse {

	private String message;
	private String ststusCode;
	
	
	public ApiResponse(String message, String ststusCode) {
		super();
		this.message = message;
		this.ststusCode = ststusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStstusCode() {
		return ststusCode;
	}
	public void setStstusCode(String ststusCode) {
		this.ststusCode = ststusCode;
	}
	
	
	
}
