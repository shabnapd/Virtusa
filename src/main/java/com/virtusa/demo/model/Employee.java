package com.virtusa.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee {
	@Id
	private String empId;
	private String empName;
	private String designation;

}
