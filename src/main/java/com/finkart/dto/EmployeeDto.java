package com.finkart.dto;

import java.util.List;

import com.finkart.entity.PhoneNumber;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String startDate;
	private String employmentType;
	private String email;
	private List<PhoneNumber> phoneNumberList;
}
