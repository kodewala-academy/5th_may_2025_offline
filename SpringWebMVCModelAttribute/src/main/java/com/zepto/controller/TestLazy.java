package com.zepto.controller;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zepto.entity.Department;
import com.zepto.entity.Employee;

public class TestLazy {
	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.configure("/com/zepto/controller/hibernate/config/hibernate.cfg.xml");
		config.addAnnotatedClass(Department.class);
		config.addAnnotatedClass(Employee.class);
		SessionFactory sessionFactory = config.buildSessionFactory();

		// Open session
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();

		// Load Department
		Department dept = session.get(Department.class, 1L); // select * from department where id=1;(Lazy Loading enabled)
		System.out.println("Department: " + dept.getName());

		System.out.println("Before accessing employees...");

		// Access lazy collection (triggers query now)
		System.out.println("Number of employees: " + dept.getEmployees().size()); // 

		txn.commit();
		session.close();

		sessionFactory.close();
	}
}
