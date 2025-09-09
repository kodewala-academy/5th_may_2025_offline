package com.kodewala;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kodewala.beans.Employee;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		String config = "beans.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		Employee employee = (Employee) context.getBean("emp1"); // getting beans from IOC container by bean id

		System.out.println(" First Name : " + employee.getFirstName());
		System.out.println(" Last Name : " + employee.getLastName());
	}
}
