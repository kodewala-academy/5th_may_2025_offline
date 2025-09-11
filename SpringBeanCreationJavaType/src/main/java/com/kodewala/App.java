package com.kodewala;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.bean.Employee;
import com.kodewala.config.SpringConfig;
import com.kodewala.service.EmployeeService;

public class App {

	public static void main(String[] args) {

		// Creating IOC container (context)
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		Employee emp = (Employee) context.getBean("emp1");
		System.out.println(emp.getFirstName());
		System.out.println(emp.getLastName());

		Employee emp2 = (Employee) context.getBean("emp2"); // accessing the bean from IOC
		System.out.println(emp2.getFirstName());
		System.out.println(emp2.getLastName());

		System.out.println(" Using Qualifier and Primary....");
		EmployeeService service = context.getBean(EmployeeService.class);
		service.printEmployee(); 

	}
}
