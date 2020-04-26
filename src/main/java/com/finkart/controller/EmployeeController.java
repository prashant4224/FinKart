package com.finkart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finkart.dto.ApiResponse;
import com.finkart.dto.EmployeeDto;
import com.finkart.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employee/v1")
@Slf4j
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createEmployee(@RequestBody EmployeeDto employeeDto) {
		
		log.info("EmployeeDto: {}", employeeDto.toString());
		
		ApiResponse response = employeeService.create(employeeDto);
		log.info("response: {}", response);
		
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}

}
