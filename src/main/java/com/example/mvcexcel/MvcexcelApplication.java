package com.example.mvcexcel;




import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import com.example.mvcexcel.model.Employee;
import com.example.mvcexcel.service.EmployeeServiceImpl;



@SpringBootApplication
public class MvcexcelApplication {
public static void printMenu(String[] options){

for (String option : options){
System.out.println(option);
}
System.out.print("Choose your option : ");
}
public static void main(String[] args) {
	SpringApplication.run(MvcexcelApplication.class, args);
{ String[] options = {"1- i want to know name",
"2- i want to know reporting manager",
"3- i want to know designation",
"4- i want to know department",
"5- i want to know Joining Date",
"6- Exit",
};

Scanner scanner = new Scanner(System.in);

int option;
while (true){
printMenu(options);
option = scanner.nextInt();
 

	
switch (option) {

case 1:
	int id = 0;
	System.out.println("Enter your Employee Id");
	id=scanner.nextInt();
	Employee employee = new Employee();
	EmployeeServiceImpl es = new EmployeeServiceImpl();
	try {
	employee = es.findEmployeeById(id);
	} catch (Exception e) {

	e.printStackTrace();
	}
	if (employee == null) {


	System.out.println("no data found");
	System.exit(option);


	}

{
	
System.out.println("Employee Id =" +employee.getId());
System.out.println("Name= " + employee.getName());
break;
}
case 2:
	int id2 = 0;
	System.out.println("Enter your Employee Id");
	id=scanner.nextInt();
	Employee employee2 = new Employee();
	EmployeeServiceImpl es2 = new EmployeeServiceImpl();
	try {
	employee2 = es2.findEmployeeById(id);
	} catch (Exception e) {

	e.printStackTrace();
	}
	if (employee2 == null) {


	System.out.println("no data found");
	System.exit(option);


	}else
	
{
	
System.out.println("Employee Id =" +employee2.getId());
System.out.println("Name= " + employee2.getName());
System.out.println("reporting manager =" +employee2.getReportingManager());
break;
}
case 3:
	int id3 = 0;
	System.out.println("Enter your Employee Id");
	id=scanner.nextInt();
	Employee employee3 = new Employee();
	EmployeeServiceImpl es3 = new EmployeeServiceImpl();
	try {
	employee3 = es3.findEmployeeById(id);
	} catch (Exception e) {

	e.printStackTrace();
	}
	if (employee3 == null) {


	System.out.println("no data found");
	System.exit(option);


	}else

{
	
System.out.println("Employee Id =" +employee3.getId());
System.out.println("Name= " + employee3.getName());
System.out.println("Designation="+ employee3.getDesignation());
break;
}

case 4:
	int id4 = 0;
	System.out.println("Enter your Employee Id");
    id=scanner.nextInt();
	Employee employee4 = new Employee();
	EmployeeServiceImpl es4 = new EmployeeServiceImpl();
	try {
	employee4 = es4.findEmployeeById(id);
	} catch (Exception e) {

	e.printStackTrace();
	}
	if (employee4 == null) {


	System.out.println("no data found");
	System.exit(option);


	}else
	
{
System.out.println("Employee Id =" +employee4.getId());
System.out.println("Name= " + employee4.getName());
System.out.println("Department="+ employee4.getDepartment());
break;
}
case 5:
	//int id = 0;
	System.out.println("Enter your Employee Id");
	id=scanner.nextInt();
	Employee employee5 = new Employee();
	EmployeeServiceImpl es5 = new EmployeeServiceImpl();
	
	try {
	employee5 = es5.findEmployeeById(id);
	} catch (Exception e) {

	e.printStackTrace();
	}
	if (employee5 == null) {


	System.out.println("no data found");
	System.exit(option);


	}else
	
{
System.out.println("Name= " + employee5.getName());
System.out.println( "Joining Date="+ employee5.getJoiningDate());
//System.out.println( "Joining Date="+ s);
break;
}
case 6 : {
	System.exit(option);
}
default:
System.out.println("no data found");

}

} 
}
}
}



