package com.finkart.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class PhoneNumber {
	
	@Id
	private Long id;
	private String type;
	private String isdCode;
	private int phoneNumber;
	private int extension;
	
	/*Bidirectional
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * @JoinColumn(name = "employee_id", nullable=false)
	 * 	
	*/
	@ManyToOne(fetch = FetchType.LAZY, optional = false) 
	@JoinColumn(name = "employee_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Employee employee;
}
