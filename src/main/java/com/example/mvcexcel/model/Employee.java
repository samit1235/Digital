package com.example.mvcexcel.model;



import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {
	
	
	private int Id;
	private String Department;
	private String Designation;
	private String ReportingManager;
	private String Name;
	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	// SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
	     ;
	private Date JoiningDate;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getReportingManager() {
		return ReportingManager;
	}
	public void setReportingManager(String reportingManager) {
		ReportingManager = reportingManager;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getJoiningDate() {
		String s;
		Format formatter;
		  //Date JoiningDate = null ;
		  formatter = new SimpleDateFormat("dd/MM/yyyy");
		  s = formatter.format(JoiningDate);
		return s;
	}
	public void setJoiningDate(Date joiningDate) {
       
     

		JoiningDate = joiningDate;
	}
	public Employee(int id, String department, String designation, String reportingManager, String name,
			Date joiningDate) {
		super();
		Id = id;
		Department = department;
		Designation = designation;
		ReportingManager = reportingManager;
		Name = name;
		JoiningDate = joiningDate;
	}
	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", Department=" + Department + ", Designation=" + Designation
				+ ", ReportingManager=" + ReportingManager + ", Name=" + Name + ", JoiningDate=" + JoiningDate + "]";
	}
public Employee() {
	// TODO Auto-generated constructor stub
}
	}