package com.mirdu.employee_management_system.service;

import java.util.ArrayList;

import com.mirdu.employee_management_system.entity.Employee;
import com.mirdu.employee_management_system.exception.WrongEmployeeException;

public class EmployeeService {

	private ArrayList<Employee> empList;

	public EmployeeService() {
		this.empList = new ArrayList<Employee>();
	}

	public boolean addEmployee(Employee e) {
		boolean b = empList.add(e);
		System.out.println("Employee got added successfully");
		return b;
	}

	public ArrayList<Employee> viewEmployee() {
		return empList;
	}

	public boolean updateEmployee(Employee e) throws WrongEmployeeException {
		boolean flag = false;
		for (Employee e1 : empList) {
			if (e1.getEmpId() == e.getEmpId()) {
				e1.setEmpName(e.getEmpName());
				e1.setEmpDsignation(e.getEmpDsignation());
				e1.setEmpSalary(e.getEmpSalary());
				flag = true;
			}
		}
		if (flag) {
			System.out.println("Employee data updated..");
		} else {
			throw new WrongEmployeeException();
		}

		return flag;
	}

	public boolean deleteEmployee(int empid) throws WrongEmployeeException {
		boolean flag = false;

		for (int i = 0; i < empList.size(); i++) {

			if (empList.get(i).getEmpId() == empid) {
				empList.remove(empList.get(i));
				flag = true;
			}
		}
		if (flag) {
			System.out.println("Employee data deleted..");
		} else {
			throw new WrongEmployeeException();
		}

		return flag;
	}

	public boolean increment(int empid, int percentage) throws WrongEmployeeException {
		boolean flag = false;
		for (Employee e1 : empList) {
				if (e1.getEmpId() == empid) {
					double sal = e1.getEmpSalary();
					e1.setEmpSalary(sal + (sal * percentage / 100));
					flag = true;
				}
			}
			if (flag) {
				System.out.println("Employee Salary Incremented..");
			} else {
				throw new WrongEmployeeException();
			}
		return flag;
}}
