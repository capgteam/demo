package org.cap.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Employee {
	@Id
	@GeneratedValue
	private int employeeId;
	private String firstName;
	private String lastName;
	private double salary;
	
	@JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
	private LocalDate dateOfJoining;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public Employee(int employeeId, String firstName, String lastName, double salary, LocalDate dateOfJoining) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.dateOfJoining = dateOfJoining;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", salary=" + salary + ", dateOfJoining=" + dateOfJoining + "]";
	}
	
	

}
