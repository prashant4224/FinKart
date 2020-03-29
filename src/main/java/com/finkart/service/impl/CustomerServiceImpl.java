package com.finkart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finkart.entity.Customer;
import com.finkart.repository.CustomerRepository;
import com.finkart.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getCustomerList(){
		return customerRepository.findAll(); 
	}
}
