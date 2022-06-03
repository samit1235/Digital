package com.example.mvcexcel.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.mvcexcel.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	

	private static List<Employee> employees;

	public EmployeeServiceImpl() {
		employees = new ArrayList<Employee>();
		employees = readEmployeeFromExcel();
	}

	private List<Employee> readEmployeeFromExcel() {
		// TODO Auto-generated method stub

	

	
		List<Employee> list = new ArrayList<Employee>();
		try {
			File file = ResourceUtils.getFile("classpath:excel/EmployeeData.xlsx");
			FileInputStream fis = null;
			fis = new FileInputStream(file.getAbsolutePath());
			@SuppressWarnings("resource")
			Workbook workbook = new XSSFWorkbook(fis);
			int numberOfSheets = workbook.getNumberOfSheets();
			for (int i = 0 ; i<numberOfSheets; i++) {
				Sheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rowIterator = sheet.iterator();
				while (rowIterator.hasNext()) {
					Employee employee = new Employee();
					Row row = rowIterator.next();
					Iterator<Cell> cellIterator = row.cellIterator();
					// Iterating over each cell (column wise) in a particular row.
					while (cellIterator.hasNext()) {
				
						Cell cell = cellIterator.next();
				
						if (cell.getColumnIndex() == 0) {
							employee.setId((int) cell.getNumericCellValue());
						} else if (cell.getColumnIndex() == 1) {
							employee.setName(cell.getStringCellValue());
						} else if (cell.getColumnIndex() == 3) {
							employee.setReportingManager(cell.getStringCellValue());
					} else if (cell.getColumnIndex() == 4) {
						employee.setDesignation(cell.getStringCellValue());
					}else if (cell.getColumnIndex() == 5) {
						employee.setDepartment(cell.getStringCellValue());
					}else if (cell.getColumnIndex() == 2) {
						employee.setJoiningDate(cell.getDateCellValue());
					}
					list.add(employee);
				}
			}
			fis.close();
			} 
			}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	
	}

	@Override
	public List<Employee> getEmployees() {
		
		return employees;
	}

	@Override
	public Employee findEmployeeById(int id) {
Employee employee=null;
for(Employee employee2:employees) {
	
		if(id==employee2.getId()) {
			employee=employee2;
			break;
		}
	
}
		return employee;
	}

	@Override
	public String findDepartmentById(int id) {
		Employee emp=null;
		for(Employee emp2:employees) {
			
				if(id==emp2.getId()) {
					emp=emp2;
					break;
				}
			
		}
				return emp.getDepartment();
	}

	@Override
	public String findNameById(int id) {
		Employee emp=null;
		for(Employee emp2:employees) {
			
				if(id==emp2.getId()) {
					emp=emp2;
					break;
				}
			
		}
				return emp.getName();
	}

	@Override
	public String findDesignationById(int id) {
		Employee emp=null;
		for(Employee emp2:employees) {
			
				if(id==emp2.getId()) {
					emp=emp2;
					break;
				}
			
		}
				return emp.getDesignation();
	}

	@Override
	public String findReportingManagerById(int id) {
		Employee emp=null;
		for(Employee emp2:employees) {
			
				if(id==emp2.getId()) {
					emp=emp2;
					break;
				}
			
		}
				return emp.getReportingManager();
	}

	@Override
	public Date findJoiningDateById(int id) {
		Employee emp=null;
		for(Employee emp2:employees) {
			
				if(id==emp2.getId()) {
					emp=emp2;
					break;
				}
			
		}
				return emp.getJoiningDate();
	}
}
