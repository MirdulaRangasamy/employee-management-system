package com.mirdu.employee_management_system.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mirdu.employee_management_system.entity.Employee;
import com.mirdu.employee_management_system.exception.WrongEmployeeException;

public class EmployeeServiceTest {
	private static EmployeeService empsvc = new EmployeeService();
	
	@BeforeClass
	public static void intialList()
	{
		empsvc.addEmployee(new Employee(101,"AAA","D1",1500.0));
		empsvc.addEmployee(new Employee(102,"BBB","D2",2500.0));
		empsvc.addEmployee(new Employee(103,"CCC","D3",3500.0));
		empsvc.addEmployee(new Employee(104,"DDD","D4",4500.0));
	}
	@Test
	public void testAddEmployee() {
		assertTrue(new EmployeeService().addEmployee(new Employee(105,"HHH","DDD",1500.0)));
	}

	@Test
	public void testViewEmployee() {
		assertNotNull(new EmployeeService().viewEmployee());
	}

	@Test
	public void testUpdateEmployee1() throws WrongEmployeeException {
		assertTrue(empsvc.updateEmployee(new Employee(102,"SSS","MM",15000.0)));
	}
	
	@Test(expected=WrongEmployeeException.class)
	public void testUpdateEmployee2() throws WrongEmployeeException {
		assertFalse(empsvc.updateEmployee(new Employee(201,"SSS","MM",15000.0)));
	}
	
	@Test
	public void testDeleteEmployee() throws WrongEmployeeException {
		assertTrue(empsvc.deleteEmployee(101));
	}

	@Test
	public void testIncrement() throws WrongEmployeeException {
		
		assertTrue(empsvc.increment(104,15));
	}
	@AfterClass
	public static void deleteList()
	{
		empsvc.viewEmployee().clear();
	}
}
