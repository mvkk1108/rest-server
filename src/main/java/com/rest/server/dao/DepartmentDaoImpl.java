package com.rest.server.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.rest.server.entities.Department;


@Component
public class DepartmentDaoImpl implements DepartmentDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Department find(int deptNo) {
		
		
		
		return jdbcTemplate.query("select * from department where deptno="+deptNo,new DepartmentResultSet());
	}

	@Override
	public List<Department> findAll() {
		
		return jdbcTemplate.query("select * from department", new DepartmentRowMapper());
	}

	@Override
	public boolean save(Department dept) {
		
		int res=  jdbcTemplate.update("insert into department values(?,?,?)", dept.getDeptno(),dept.getDname(),dept.getLcode());
		
		if(res>=1)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int deptno) {
	int res=  jdbcTemplate.update("delete from department where deptno="+deptno);
		
		if(res>=1)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Department dept) {
		
		int res = jdbcTemplate.update("update department set dname =? , lcode=? where deptno=?", dept.getDname(),dept.getLcode(),dept.getDeptno());
		
		if(res>=1)
		{
			return true;
		}
		return false;
	}

}
