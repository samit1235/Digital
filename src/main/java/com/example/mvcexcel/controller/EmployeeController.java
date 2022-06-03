package com.example.mvcexcel.controller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvcexcel.model.Employee;
import com.example.mvcexcel.service.EmployeeService;
@RestController
@RequestMapping("/Employee")
public class EmployeeController {

@Autowired(required = true)
EmployeeService employeeService;


	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
		System.out.println("Fetching Employee with id " + id);
		Employee employee = employeeService.findEmployeeById(id);
		if (employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@GetMapping(value = "/get", headers = "Accept=application/json")
	public List<Employee> getEmployees() {
		List<Employee> tasks = employeeService.getEmployees();
		return tasks;

	}
	@GetMapping(value = "depa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getDepartmentById(@PathVariable("id") int id) {
		System.out.println("Fetching Employee with id " + id);
		String employee = employeeService.findDepartmentById(id);
		if (employee == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<String>(employee, HttpStatus.OK);
	}
	@PostMapping(value = "inv/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeesById(@PathVariable("id") int id) {
		System.out.println("Fetching Employee with id " + id);
		Employee employee = employeeService.findEmployeeById(id);
		if (employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	

	{
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
}
}	

