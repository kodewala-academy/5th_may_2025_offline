package com.kodewala.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.kodewala.bean.Employee;

@Configuration
@ComponentScan(basePackages = "com.kodewala") 
public class SpringConfig {

	@Bean("emp1")
	@Primary
	public Employee createEmpObj1() {
		Employee employee = new Employee();
		employee.setFirstName("Kodewala");
		employee.setLastName("Academy");
		return employee;
	}
	
	@Bean("emp2")
//	@Primary // default in case of conflict 
	public Employee createEmpObj2() {
		Employee employee = new Employee();
		employee.setFirstName("Amit");
		employee.setLastName("Kumar");
		return employee;
	}

}
