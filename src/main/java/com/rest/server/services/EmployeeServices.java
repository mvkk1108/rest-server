package com.rest.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.server.dao.EmployeeDao;
import com.rest.server.entities.Employee;
import com.rest.server.entities.EmployeeDTO;
import com.rest.server.exception.BadResourceRequestException;
import com.rest.server.exception.ResourceNotFoundException;

@Service
public class EmployeeServices {
	@Autowired
	private EmployeeDao empDao;
	
	public EmployeeDTO getEmployees()
	{
		List<Employee> empList = empDao.findAll();
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmployees(empList);
		return dto;
	}

	
	public Employee getEmployee(int empno)
	{
		Employee emp = empDao.find(empno);
		if(emp==null)
		{
			throw new ResourceNotFoundException("Employee Not Found");
		}
		
		return emp;
	}
	
	
	public void createNewEmployee(Employee emp)
	{
		Employee existingEmployee = empDao.find(emp.getEmpno());
		
		if(existingEmployee!=null)
		{
			throw new BadResourceRequestException("Duplicate employee Found");
		}else
		{
			empDao.save(emp);
		}
	}
}
