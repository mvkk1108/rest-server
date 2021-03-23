package com.rest.server.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.server.dao.DepartmentDao;
import com.rest.server.entities.Department;
import com.rest.server.exception.BadResourceRequestException;
import com.rest.server.exception.ResourceNotFoundException;
@Service("deptService")
public class DepartmentServices {
	@Autowired
	private DepartmentDao deptDao;
	
	public List<Department> getAllDepts()
	{
	return deptDao.findAll();	
	}
	
	
	public Department getDepartment(int deptno)
	{
	Department dept =	deptDao.find(deptno);
	
	
	   if(dept==null)
	   {
		   throw new ResourceNotFoundException("No Department Found with id : "+deptno);
	   }
	return dept;
	}
	
	
	
	public void createDepartment(Department dept)
	{
		
		  Department existindDepartment = deptDao.find(dept.getDeptno());
		  if(existindDepartment!=null)
		  {
			  throw new BadResourceRequestException("Duplicate Department with id "+dept.getDeptno());
		  }
		  else
		  {
			  deptDao.save(dept);
		  }
		
	}
	
	
	
	
	public  void deleteDepartment(int deptno)
	{
		Department dept =	deptDao.find(deptno);
		
		
		   if(dept==null)
		   {
			   throw new ResourceNotFoundException("No Department Found with id : "+deptno+" to delete");
		   }else
		   {
			   deptDao.delete(deptno);
		   }
		   
		   
	}
	
	
	public void updateDepartment(Department dept)
	{
		Department Existingdept =	deptDao.find(dept.getDeptno());
		
		
		   if(Existingdept==null)
		   {
			   throw new ResourceNotFoundException("No Department Found with id : "+dept.getDeptno()+" to update");
		   }else
		   {
			   deptDao.update(dept);
		   }
		   
	}
}
