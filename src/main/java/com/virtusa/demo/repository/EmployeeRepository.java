package com.virtusa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
