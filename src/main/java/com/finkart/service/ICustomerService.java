package com.finkart.service;

import java.util.List;

import com.finkart.entity.Customer;

/**
 * @author PRASHANT
 * 
 * The Interface ICustomerService.
 */
public interface ICustomerService {
	
	public List<Customer> getCustomerList();
	
	public Customer createCustomer(Customer cust);

	//public void updateCustomer();
	

}
