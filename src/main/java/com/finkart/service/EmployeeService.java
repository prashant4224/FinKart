package com.finkart.service;

import org.springframework.stereotype.Service;

import com.finkart.constants.FinKartConstants;
import com.finkart.dto.ApiResponse;
import com.finkart.dto.EmployeeDto;


@Service
public class EmployeeService implements IEmployeeService {

	public ApiResponse create(EmployeeDto employeeDto) {
		
		return new ApiResponse(FinKartConstants.CREATED,FinKartConstants.SUCCESS);
	}
}
