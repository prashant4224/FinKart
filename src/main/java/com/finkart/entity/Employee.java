package com.finkart.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Employee {

	@Id
	private Long id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String startDate;
	private String employmentType;
	private String email;

	/* Bidirectional
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
	 * private Set<PhoneNumber> phoneNumberList = new HashSet<>();
	*/
}
