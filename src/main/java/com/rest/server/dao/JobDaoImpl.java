package com.rest.server.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.rest.server.entities.Job;


@Component
public class JobDaoImpl  implements JobDao{
     @Autowired
	 private JdbcTemplate jdbctemplate;
	
	
	@Override
	public Job find(int jcode) {
		
		
		PreparedStatementSetter setter = new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, jcode);
				
			}
		};
		
		return jdbctemplate.query("select * from job where jcode=?", setter, new ResultSetExtractor<Job>() {

			@Override
			public Job extractData(ResultSet rs) throws SQLException, DataAccessException {
			
				Job job = null;
				if(rs.next())
			 {
					job =new Job();
					job.setJcode(rs.getInt(1));
					job.setJname(rs.getString(2));
				 
			 }
				return job;
			}
		});
		//return jdbctemplate.query("select * from job where jcode=?", setter, new JobRowMapper());
		//return jdbctemplate.queryForObject("select * from job where jcode=?", new JobRowMapper(), jcode);
	}

	@Override
	public List<Job> findAll() {
	
		return jdbctemplate.query("select * from job", new JobRowMapper());
	}

	@Override
	public boolean save(Job job) {
		
		int res =jdbctemplate.update("insert into job values(?,?)", job.getJcode(),job.getJname());
		
		if(res >=1)
			return true;
		return false;
	}

	@Override
	public boolean update(int jcode, Job job) {
		
		
		int res = jdbctemplate.update("update job set name=? where jocde=?", job.getJname(),jcode);
		if(res>=1)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int jcode) {
		
		int res = jdbctemplate.update("delete from job where jcode=?", jcode);
		if(res>=1)
		{
			return true;
		}
		
		return false;
	}

}
