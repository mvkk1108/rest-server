package com.rest.server.entities;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class Job {
	

	private int jcode;
	
	private String jname;
	public int getJcode() {
		return jcode;
	}
	public void setJcode(int jcode) {
		this.jcode = jcode;
	}
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	@Override
	public String toString() {
		return "Job [jcode=" + jcode + ", jname=" + jname + "]";
	}
	

}
