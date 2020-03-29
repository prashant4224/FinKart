package com.finkart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finkart.entity.Customer;
import com.finkart.service.CustomerService;

@RestController
@RequestMapping("/customer/v1")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/cust-list")
	public ResponseEntity<List<Customer>> allCustomers(){
		
		List<Customer> custList = customerService.getCustomerList();
		
		return new ResponseEntity<List<Customer>>(custList, HttpStatus.OK);
	}
	
}
