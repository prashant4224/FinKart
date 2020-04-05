package com.finkart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finkart.entity.Customer;
import com.finkart.repository.CustomerRepository;

/**
 * @author PRASHANT
 * 
 * The Class CustomerService.
 */
@Service
public class CustomerService implements ICustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getCustomerList(){
		return customerRepository.findAll(); 
	}
	
	public Customer createCustomer(Customer cust) {
//		System.out.println(cust.toString());
		return customerRepository.save(cust);
	}
}
