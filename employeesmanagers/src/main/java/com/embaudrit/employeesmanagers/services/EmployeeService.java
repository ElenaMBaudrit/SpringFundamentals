package com.embaudrit.employeesmanagers.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.embaudrit.employeesmanagers.models.Employee;
import com.embaudrit.employeesmanagers.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	public EmployeeService (EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public Employee findByName(String firstName, String lastName) {
		return employeeRepository.findByFullName(firstName, lastName);
	}
	
	public void createEmployee (Employee employee) {
		employeeRepository.save(employee);
	}
	
	public Employee findById (Long Id) {
		Optional <Employee> employee = employeeRepository.findById(Id);
		if (employee == null) {
			return null;
		}
		else {
			return employee.get();
		}
	}
}
