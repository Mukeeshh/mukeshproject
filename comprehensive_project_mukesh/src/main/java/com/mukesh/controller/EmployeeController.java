package com.mukesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mukesh.exception.EmployeeAlreadyExistsException;
import com.mukesh.service.EmployeeService;

@RestController

public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/saveEmployee")
	public Employee saveDoctor(@RequestBody Employee employee) throws 
	EmployeeAlreadyExistsException{
		return service.saveEmployee(employee);
	}
	@GetMapping("/info")
	public List<Employee> getAllEmployees(){
		return service.getAllEmployees();
	}
	@PutMapping("/update/{salary}")
	public Employee updateDoctor(@RequestBody Employee employee, @PathVariable Double salary) {
		return service.updateEmployee(employee,salary);
	}
	
	}
	


