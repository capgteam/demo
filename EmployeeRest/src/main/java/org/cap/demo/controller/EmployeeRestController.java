package org.cap.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;
import org.cap.demo.model.Employee;
import org.cap.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EmployeeRestController {

	@Autowired
	private IEmployeeService employeeDbService;
	
	@PostMapping("/employees")
	public ResponseEntity<List<Employee>> addEmployee(@RequestBody Employee employee,
			HttpServletRequest request){
		List<Employee> employees= employeeDbService.addNewEmployee(employee);
		
		//creates session
		HttpSession session= request.getSession();
		//bind session object key-value
		session.setAttribute("userName", employee.getFirstName());
		session.setAttribute("empid", employee.getEmployeeId());
		
		
		if(employees==null || employees.isEmpty())
			return new ResponseEntity("Insert Error!",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(HttpSession session){
		List<Employee> employees= employeeDbService.getAllEmployees();
		
		String userName=session.getAttribute("userName").toString();
		String empid=session.getAttribute("empid").toString();
		
		System.out.println("****************************************************");
		System.out.println("UserName:" + userName);
		System.out.println("Employee ID:" +empid);
		System.out.println("****************************************************");
		
		if(employees==null || employees.isEmpty())
			return new ResponseEntity("Sorry! No Employee Available!",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	
	@GetMapping("/logout")
	public void logoutUser(HttpSession session) {
		session.invalidate(); //in validate my session
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
