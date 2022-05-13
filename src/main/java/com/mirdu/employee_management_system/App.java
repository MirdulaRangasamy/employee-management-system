package com.mirdu.employee_management_system;

import java.util.ArrayList;
import java.util.Scanner;

import com.mirdu.employee_management_system.entity.Employee;
import com.mirdu.employee_management_system.exception.WrongEmployeeException;
import com.mirdu.employee_management_system.service.EmployeeService;

public class App {
	public static void main(String[] args) throws WrongEmployeeException {
		Scanner ip = new Scanner(System.in);		
		char ch = 'Y';
		int id;
		String name, desig;
		double sal;
		Employee e;
		
		EmployeeService empservice = new EmployeeService();
		
		while (ch == 'Y') {
			System.out.println("Employee Management System");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employee");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Salary Increment");
						
			System.out.println("Enter your choice:");
			int option = ip.nextInt();
			
			switch (option) {
				case 1:
					System.out.println("Enter the details of an employee:");
					System.out.println("Enter the emp ID:");
					id = ip.nextInt();
					System.out.println("Enter the emp Name:");
					name = ip.next();
					System.out.println("Enter the emp Designation:");
					desig = ip.next();
					System.out.println("Enter the emp salary");
					sal = ip.nextDouble();
					e = new Employee(id, name, desig, sal);
					empservice.addEmployee(e);
					break;
				case 2:
					empservice.viewEmployee();
					break;
				case 3:
					System.out.println("Enter the details of an employee:");
					System.out.println("Enter the emp ID:");
					id = ip.nextInt();
					System.out.println("Enter the emp Name:");
					name = ip.next();
					System.out.println("Enter the emp Designation:");
					desig = ip.next();
					System.out.println("Enter the emp salary");
					sal = ip.nextDouble();
					e = new Employee(id, name, desig, sal);
					empservice.updateEmployee(e);
					break;
				case 4:
					System.out.println("Enter the id of the employee need to deleted:");
					System.out.println("Enter the emp ID:");
					id = ip.nextInt();
					empservice.deleteEmployee(id);
					break;
				case 5:
					System.out.println("Enter the emp id for increment:");
					id = ip.nextInt();
					System.out.println("Enter the percentage of increment:");
					int per = ip.nextInt();
					empservice.increment(id, per);
					break;
				default:
					System.out.println("Wrong Option");
					break;
			}
			System.out.println("Want to continue press Y...");
			ch = ip.next().charAt(0);
		}
		System.out.println("Thank you for Using....");
	}
}
