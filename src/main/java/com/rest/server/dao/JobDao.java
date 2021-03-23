package com.rest.server.dao;

import java.util.List;

import com.rest.server.entities.Job;


public interface JobDao {
	
	public Job find(int jcode);
	public List<Job> findAll();
	public boolean save(Job job);
	public boolean update(int jcode, Job job);
	public boolean delete(int jcode);

}
