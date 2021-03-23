package com.rest.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.rest.server.entities.Department;

public class DepartmentResultSet implements ResultSetExtractor<Department> {

	@Override
	public Department extractData(ResultSet rs) throws SQLException, DataAccessException {
		  Department dept= null;
		
		  
		     if(rs.next())
		     {
		    	 dept = new Department();
		    	 dept.setDeptno(rs.getInt(1));
		    	 dept.setDname(rs.getString(2));
		    	 dept.setLcode(rs.getInt(3));
		     }
		
		return dept;
	}

}
