package com.rest.server.dao;

import java.util.List;

import com.rest.server.entities.Department;


public interface DepartmentDao {
	
	public Department find(int deptNo);
	public List<Department> findAll();
	
	public boolean save(Department dept);
	
	public boolean delete(int deptno);
	public boolean update(Department dept);
	
	

}
