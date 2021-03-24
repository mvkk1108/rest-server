package com.rest.server.entities;

import java.util.List;

public class EmployeeDTO {

	private List<Employee>  employees;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}
