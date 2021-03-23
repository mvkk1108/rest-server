package com.rest.server.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rest.server.entities.Department;
import com.rest.server.entities.DepartmentDTO;
import com.rest.server.services.DepartmentServices;

@RestController

@RequestMapping("/ems/api")
@Validated
public class DepartmentController {
	
	@Autowired
	private DepartmentServices deptService;
	
	@GetMapping("/departments")
	public ResponseEntity<DepartmentDTO>    depts()
	{
		
		DepartmentDTO dto = new DepartmentDTO();
		dto.setDepartment(deptService.getAllDepts());
		
		
		
		  ResponseEntity<DepartmentDTO> responseEntity = new ResponseEntity<DepartmentDTO>(dto, HttpStatus.OK);
	//return 	deptService.getAllDepts();
		  return responseEntity;
	}


	@GetMapping("/department/{deptno}")
	public ResponseEntity<Department> getDepartment(@PathVariable(name = "deptno") int deptno)
	{
		
		System.out.println(deptno);
		Department dept = deptService.getDepartment(deptno);
		System.out.println(dept);
		ResponseEntity<Department> deptResp = new ResponseEntity<Department>(dept,HttpStatus.OK);
	return deptResp;
	
	}
	
	@GetMapping("/department")  // @PathParam in place of @RequestParam
	public ResponseEntity<Department> getDepartmentById(@RequestParam(name="deptno",defaultValue = "0") @Min(1) int deptno)
	{
		
		System.out.println(deptno);
		Department dept = deptService.getDepartment(deptno);
		System.out.println(dept);
		ResponseEntity<Department> deptResp = new ResponseEntity<Department>(dept,HttpStatus.OK);
		return deptResp;
	}
	
	
	
	@PostMapping("/department")
	@ResponseStatus(HttpStatus.CREATED)
	public  Department createNewDepartment(  @RequestBody @Valid Department dept)
	{
		deptService.createDepartment(dept);
		
		return  dept;
	}
	
	//http://localhost:8080/ems/api/depeartment?deptno=<value> - DELETE 
	//@RequestMapping(value="/department",method = RequestMethod.DELETE)
	@DeleteMapping("/department")
	public ResponseEntity<?> deleteDepartment(@RequestParam("deptno") int deptno)
	{
		
		 deptService.deleteDepartment(deptno);
		 
		 return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
		
		
		
	}
	
	//@RequestMapping(value="/department",method = RequestMethod.PUT)
	@PutMapping("/department")
	public Department updateDepartment(@RequestBody Department dept)
	{
		System.out.println(dept);
		deptService.updateDepartment(dept);
		
		return dept;
		
	}
	
	
	
}
