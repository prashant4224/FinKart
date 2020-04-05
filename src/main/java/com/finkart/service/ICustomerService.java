package com.finkart.service;

import java.util.List;
import java.util.Map;

import com.finkart.entity.Customer;

/**
 * @author PRASHANT
 * 
 * The Interface ICustomerService.
 */
public interface ICustomerService {
	
	public List<Customer> getCustomerList();
	
	public Customer createCustomer(Customer cust);
	public List<Customer> bulkCreateCustomer(List<Customer> custList);

	public Customer updateCustomer(Customer cust);
	
	public Customer getCustomer(long id);
	
	public Customer partialUpdate(Map<String, Object> cust, Long id) throws Exception;
	
	public void deleteCustomer(Long id);
	

}
