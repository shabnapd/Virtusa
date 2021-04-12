package com.virtusa.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.demo.model.Employee;
import com.virtusa.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository empRepo;

	public Optional<Employee> getEmployee(String empId) {
		return empRepo.findById(empId);

	}

	public Employee addEmployee(Employee employee) {
		if (!empRepo.existsById(employee.getEmpId())) {
			return empRepo.save(employee);
		}
		return null;

	}

	public Employee updateEmployee(String empId, Employee employee) {
		if (empRepo.existsById(empId)) {
			return empRepo.save(employee);

		}
		return null;

	}

	public String deleteEmployee(String empId) {
		if (empRepo.existsById(empId)) {
			empRepo.deleteById(empId);
			return "SUCCESS";
		}
		return null;

	}

}
