package com.virtusa.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.demo.model.Employee;
import com.virtusa.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	final static String SUCCESS = "Success";
	@Autowired
	private EmployeeService empService;

	@GetMapping(value = "/getEmployee/{empId}")
	public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable String empId) {
		HttpHeaders headers = new HttpHeaders();
		Optional<Employee> emp = empService.getEmployee(empId);

		return new ResponseEntity<Optional<Employee>>(emp, headers, HttpStatus.OK);

	}

	@PostMapping(value = "/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		HttpHeaders headers = new HttpHeaders();
		Employee employee = empService.addEmployee(emp);
		return new ResponseEntity<Employee>(employee, headers, HttpStatus.OK);
	}

	@PutMapping(value = "/updateEmployee/{empId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable String empId, @RequestBody Employee emp) {
		HttpHeaders headers = new HttpHeaders();
		Employee employee = empService.updateEmployee(empId, emp);
		if (employee != null) {
			return new ResponseEntity<Employee>(employee, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<Employee>(employee, headers, HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping(value = "/deleteEmployee/{empId}")
	public String deleteEmployee(@PathVariable String empId) {
		return empService.deleteEmployee(empId);

	}
}
