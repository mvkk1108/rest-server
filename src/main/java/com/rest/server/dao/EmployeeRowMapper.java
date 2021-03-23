package com.rest.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rest.server.entities.Employee;



public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employee emp = new Employee();
		emp.setEmpno(rs.getInt(1));
		emp.setEmpname(rs.getString(2));
		emp.setJcode(rs.getInt(3));
		emp.setMgrno(rs.getInt(4));
		emp.setHiredate(rs.getDate(5));
		emp.setSalary(rs.getDouble(6));
		emp.setCommision(rs.getDouble(7));
		emp.setDeptno(rs.getInt(8));
		emp.setUsername(rs.getString(10));
		emp.setPassword(rs.getString(9));
		return emp;
	}

}
