package com.kodewala.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kodewala.bean.Employee;

@Configuration
public class SpringConfig {

	@Bean("emp1")
	public Employee createEmpObj1() {
		Employee employee = new Employee();
		employee.setFirstName("Kodewala");
		employee.setLastName("Academy");
		return employee;
	}
	
	@Bean("emp2")
	public Employee createEmpObj2() {
		Employee employee = new Employee();
		employee.setFirstName("Amit");
		employee.setLastName("Kumar");
		return employee;
	}

}
