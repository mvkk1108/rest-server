package com.rest.server.entities;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Department {
	@Min(value = 1)
	private int deptno;
	@Size(min = 3,max = 20, message = "Department Name Must be between 3 and 2- character")
	private String dname;
	private int lcode;
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getLcode() {
		return lcode;
	}
	public void setLcode(int lcode) {
		this.lcode = lcode;
	}
	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", dname=" + dname + ", lcode=" + lcode + "]";
	}
	
	

}
