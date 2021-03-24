package com.rest.server.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rest.server.entities.Employee;
import com.rest.server.entities.EmployeeDTO;
import com.rest.server.services.EmployeeServices;

@RestController
@RequestMapping("/ems/api")
public class EmployeeController {
	@Autowired
	private EmployeeServices empServices;
	@RequestMapping(value="/employees",method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<EmployeeDTO> employees()
	{
		EmployeeDTO empdto = empServices.getEmployees();
		
		return new ResponseEntity<EmployeeDTO>(empdto, HttpStatus.OK);
	}
	@GetMapping("/employee/{empid}")
	@ResponseStatus(HttpStatus.OK)
	public Employee getEmployee(@PathVariable("empid") int empid)
	{
		Employee employee = empServices.getEmployee(empid);
		
		return employee;
	}

	@PostMapping("/employee")
	public ResponseEntity<?> createEmployee(@RequestBody @Valid Employee emp)
	{
		empServices.createNewEmployee(emp);
		return new ResponseEntity<String>("Employee Created", HttpStatus.CREATED);
	}
}
