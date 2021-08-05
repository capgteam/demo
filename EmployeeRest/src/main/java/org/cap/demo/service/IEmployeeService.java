package org.cap.demo.service;

import java.util.List;

import org.cap.demo.model.Employee;

public interface IEmployeeService {
	
	public List<Employee> getAllEmployees();
	public List<Employee> addNewEmployee(Employee employee);

}
