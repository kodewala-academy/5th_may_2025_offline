package com.kodewala;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.bean.Employee;
import com.kodewala.config.SpringConfig;


public class App {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
		Employee emp = applicationContext.getBean(Employee.class);
		System.out.println(emp.getFirstName());
	}
}
