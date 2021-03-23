package com.rest.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.rest.server.entities.Employee;



public class EmployeeResultSetExtracter implements ResultSetExtractor<Employee> {

	@Override
	public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		Employee emp = null;
		if(rs.next())
		{
			 emp = new Employee();
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
		}
		
		return emp;
	}

}
