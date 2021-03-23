package com.rest.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rest.server.entities.Job;



public class JobRowMapper implements RowMapper<Job> {

	@Override
	public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
	Job job = new Job();
	job.setJcode(rs.getInt(1));
	job.setJname(rs.getString(2));
	
		return job;
	}

}
