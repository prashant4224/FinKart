package com.finkart.dto;

import java.util.ArrayList;
import java.util.List;

import com.finkart.entity.User;

/**
 * @author PRASHANT
 * 
 * The Class CustomerRequestDto.
 */
public class UserRequestDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String address1;
	private String address2;
	private String address3;
	private String city;
	private String state;
	private String pinCode;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	@Override
	public String toString() {
		return "CustomerRequestDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address1="
				+ address1 + ", address2=" + address2 + ", address3=" + address3 + ", city=" + city + ", state=" + state
				+ ", pinCode=" + pinCode + "]";
	}
	
	public static List<UserRequestDto> convertEntityToDto(List<User> custList){
		List<UserRequestDto> requestDtoList = new ArrayList<>();
		for (User customer : custList) {
			UserRequestDto customerRequestDto = new UserRequestDto();
			customerRequestDto.setId(customer.getId());
			customerRequestDto.setFirstName(customer.getFirstName());
			customerRequestDto.setLastName(customer.getLastName());
			customerRequestDto.setAddress1(customer.getAddress1());
			customerRequestDto.setAddress2(customer.getAddress2());
			customerRequestDto.setAddress3(customer.getAddress3());
			customerRequestDto.setCity(customer.getCity());
			customerRequestDto.setState(customer.getState());
			customerRequestDto.setPinCode(customer.getPinCode());
			requestDtoList.add(customerRequestDto);
		}		
		return requestDtoList;
	}
	
	public static List<User> convertDtoToEntity(List<UserRequestDto> respDtoList){
		List<User> custList = new ArrayList<>();
		for (UserRequestDto customerReq : respDtoList) {
			User customer = new User();
			customer.setId(customerReq.getId());
			customer.setFirstName(customerReq.getFirstName());
			customer.setLastName(customerReq.getLastName());
			customer.setAddress1(customerReq.getAddress1());
			customer.setAddress2(customerReq.getAddress2());
			customer.setAddress3(customerReq.getAddress3());
			customer.setCity(customerReq.getCity());
			customer.setState(customerReq.getState());
			customer.setPinCode(customerReq.getPinCode());
			custList.add(customer);
		}		
		return custList;
	}

}
