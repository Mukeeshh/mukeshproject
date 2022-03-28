package com.mukesh.service;

import java.util.Collections;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mukesh.controller.Employee;
import com.mukesh.controller.list;
import com.mukesh.exception.EmployeeAlreadyExistsException;
import com.mukesh.repository.EmployeeRepository;
import com.mukesh.util.ComparatorEmployeeSalary;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repo;

	public Employee saveEmployee(Employee e) throws EmployeeAlreadyExistsException{
		List<Employee> l = (List<Employee>)repo.findAll();
		for (Employee s : l) {
			if(e.getId() == s.getId()) {
				throw new EmployeeAlreadyExistsException("Employee with "
						+ "given ID already exists in database");
			}
		}
		return repo.save(e);
	}

	public Employee updateEmployee(Employee d, Double salary) {
		List<Employee> l = (List<Employee>)repo.findAll();
		Integer id = 0;
		for(Employee s : l) {
			if (s.getSalary()==salary) {
				id = s.getId();
			}
		}
		return null;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> l = (List<Employee>) repo.findAll();
		Collections.sort(l,new ComparatorEmployeeSalary());
		return l;
	}

}
