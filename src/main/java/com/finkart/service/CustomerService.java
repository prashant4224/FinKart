package com.finkart.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
		return customerRepository.save(cust);
	}
	
	public List<Customer> bulkCreateCustomer(List<Customer> custList){
		return customerRepository.saveAll(custList);
	}
	
	public Customer getCustomer(long id) {
		return customerRepository.getOne(id);
	}
	
	public Customer updateCustomer(Customer cust) {
		return customerRepository.save(cust);
	}
	
	public Customer partialUpdate(Map<String, Object> cust, Long id) throws Exception {
		Customer customer = customerRepository.findById(id).orElseThrow(() -> new Exception("Customer not found " + cust.get("firstName")));
		if (cust.containsKey("firstName")) {
			customer.setFirstName((String)cust.get("firstName"));
		}		
		if (cust.containsKey("lastName")) {
			customer.setLastName((String)cust.get("lastName"));
		}
		if (cust.containsKey("address1")) {
			customer.setAddress1((String)cust.get("address1"));
		}
		if (cust.containsKey("address2")) {
			customer.setAddress2((String)cust.get("address2"));
		}
		if (cust.containsKey("address3")) {
			customer.setAddress3((String)cust.get("address3"));
		}
		if (cust.containsKey("city")) {
			customer.setCity((String)cust.get("city"));
		}
		if (cust.containsKey("state")) {
			customer.setState((String)cust.get("state"));		
		}
		if (cust.containsKey("pinCode")) {
			customer.setPinCode((String)cust.get("pinCode"));
		}
		return customerRepository.save(customer);
	}
	
	@Override
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}
}
