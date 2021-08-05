package org.cap.demo.service;

import java.util.List;

import org.cap.demo.dao.IEmployeeDBDao;
import org.cap.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeDbService")
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeDBDao employeeDbDao;

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeDbDao.findAll();
	}

	@Override
	public List<Employee> addNewEmployee(Employee employee) {
		employeeDbDao.save(employee);
		return getAllEmployees();
	}

	
}
