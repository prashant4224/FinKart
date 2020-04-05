package com.finkart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finkart.entity.Customer;
import com.finkart.service.ICustomerService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author PRASHANT
 * 
 * The Class CustomerController.
 */
@RestController
@RequestMapping("/customer/v1")
@Slf4j
public class CustomerController {

	@Autowired
	private ICustomerService customerService;
	
	@GetMapping("/cust-list")
	public ResponseEntity<List<Customer>> allCustomers(){		
		List<Customer> custList = customerService.getCustomerList();
		
		return new ResponseEntity<List<Customer>>(custList, HttpStatus.OK);
	}
	
	@PostMapping(value="/create", consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE, headers="Accept=application/json")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer cust){
		Customer customer = customerService.createCustomer(cust);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
}
