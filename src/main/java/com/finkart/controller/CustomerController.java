package com.finkart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finkart.entity.Customer;
import com.finkart.service.ICustomerService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author PRASHANT
 * 
 *         The Class CustomerController.
 */
@RestController
@RequestMapping("/customer/v1")
@Slf4j
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	/**
	 * All customers.
	 *
	 * @return the response entity
	 */
	@GetMapping("/cust-list")
	public ResponseEntity<List<Customer>> allCustomers() {
		List<Customer> custList = customerService.getCustomerList();
		
		log.info("allCustomers :: {} ", custList.toString());
		return new ResponseEntity<List<Customer>>(custList, HttpStatus.OK);
	}

	/**
	 * Creates the customer.
	 *
	 * @param cust the cust
	 * @return the response entity
	 */
	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer cust) {
		Customer customer = customerService.createCustomer(cust);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@PostMapping(value = "/bulk-create", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
	public ResponseEntity<List<Customer>> bulkCreateCustomer(@RequestBody List<Customer> custList) {
		List<Customer> customerList = customerService.bulkCreateCustomer(custList);
		return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
	}

	@GetMapping(value="/customer/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE, headers="Accept=application/json")
	public ResponseEntity<Customer> getCustomer(@PathVariable long id){
		Customer cust = customerService.getCustomer(id);
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}
	
	@PutMapping(value="/customer", consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE, headers="Accept=application/json")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
		Customer cust = customerService.updateCustomer(customer);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
	@PutMapping(value="/customer/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE, headers="Accept=application/json")
	public ResponseEntity<Customer> partialUpdateCustomer(@RequestBody Map<String, Object> updates, 
			@PathVariable Long id) throws Exception{
		Customer cust = customerService.partialUpdate(updates, id);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);		
	}
	
	public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id){
		customerService.deleteCustomer(id);
		return new ResponseEntity<Customer>(HttpStatus.OK);
	}

	
}
