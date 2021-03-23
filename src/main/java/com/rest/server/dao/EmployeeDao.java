package com.rest.server.dao;

import java.util.List;

import com.rest.server.entities.Employee;



public interface EmployeeDao {

	
	public Employee find(int empno);
	public List<Employee> findAll();
	public boolean save(Employee emp);
	public boolean update(Employee emp);
	public boolean delete(Employee emp);
	public Employee findByUserName(String username);
}
