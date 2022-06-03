package com.example.mvcexcel.controller;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.mvcexcel.model.Employee;

@RestController
@RequestMapping("/employee")
public class ExcelController {
	

	@PostMapping("excel")
	public String excelReader(@RequestParam("file") MultipartFile excel) {
		
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(excel.getInputStream());
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			
			for(int i=0; i<sheet.getPhysicalNumberOfRows();i++) {
				XSSFRow row = sheet.getRow(i);
				for(int j=0;j<row.getPhysicalNumberOfCells();j++) {
					DataFormatter dataformatter = new DataFormatter();
					System.out.print(dataformatter.formatCellValue(row.getCell(j)) +" ");
				}
				System.out.println("");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Success";
		
	}
ArrayList<Employee> employees=new ArrayList<>();
	


//	@GetMapping()
//	public ArrayList<Employee> getMsg()
//	{
//		return employees;
//	}
//	
	@GetMapping(value="excel/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId)
	{
		
		for(Employee employee:employees)
		{
			if(employee.getId()==employeeId)
			{
				return employee;
			}
		}
		
		return new Employee();
	}


}