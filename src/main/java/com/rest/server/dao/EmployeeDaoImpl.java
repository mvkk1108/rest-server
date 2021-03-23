package com.rest.server.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.rest.server.entities.Employee;


@Component
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
 private JdbcTemplate jdbcTemplate;
	@Override
	public Employee find(int empno) {
		
		return jdbcTemplate.query("select * from employee where empno="+empno, new EmployeeResultSetExtracter());
	}

	@Override
	public List<Employee> findAll() {
		
		return jdbcTemplate.query("select * from employee", new EmployeeRowMapper());
	}

	@Override
	public boolean save(Employee emp) {
		
	int res =	jdbcTemplate.update("insert into employee values(?,?,?,?,?,?,?,?,?,?)", emp.getDeptno(),emp.getEmpname(),emp.getJcode(),emp.getMgrno(),emp.getHiredate(),
				emp.getSalary(),emp.getCommision()
				,emp.getDeptno(),emp.getPassword(),emp.getUsername());
		
		
		if(res>=1)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Employee emp) {
	
		return false;
	}

	@Override
	public boolean delete(Employee emp) {
		
		return false;
	}

	@Override
	public Employee findByUserName(String username) {
		
		return jdbcTemplate.query("select * from employee where username='"+username+"'", new EmployeeResultSetExtracter());
	}

}
