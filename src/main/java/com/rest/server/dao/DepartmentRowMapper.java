package com.rest.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rest.server.controllers.DepartmentController;
import com.rest.server.entities.Department;


public class DepartmentRowMapper implements RowMapper<Department> {

	@Override
	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		Department d= new Department();
		d.setDeptno(rs.getInt(1));
		d.setDname(rs.getString(2));
		d.setLcode(rs.getInt(3));
		return d;
	}

}
