package com.kodewala.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.kodewala.bean.Address;
import com.kodewala.bean.Employee;

@Configuration
@ComponentScan(basePackages = "com.kodewala.bean")
public class SpringConfig {

	@Bean
	public Address address() {
		return new Address("Bangalore", "Karnataka");
	}

	// Constructor Injection Employee bean
	@Bean
	public Employee employee() {
		return new Employee(address()); // mandatory and immutability 
	}
}
