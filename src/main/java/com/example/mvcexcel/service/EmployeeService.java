package com.example.mvcexcel.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.example.mvcexcel.model.Employee;

public interface EmployeeService {
	 public List<Employee> getEmployees();
	 public Employee findEmployeeById(int id);
	 public String findDepartmentById(int id);
	 public String findNameById(int id);
	 public String findDesignationById(int id);
	 public String findReportingManagerById(int id);
	 public Date findJoiningDateById(int id);
}
