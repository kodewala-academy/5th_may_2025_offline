
package com.kodewala.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.kodewala.bean.Employee;

@Component
public class EmployeeService {

	@Autowired
	@Qualifier("emp2") // tells Spring to inject emp1	
	private Employee employee;

	public void printEmployee() {
		System.out.println(employee.getFirstName() + " " + employee.getLastName());
	}
}
