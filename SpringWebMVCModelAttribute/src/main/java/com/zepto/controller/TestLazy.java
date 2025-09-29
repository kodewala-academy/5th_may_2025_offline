package com.zepto.controller;

import java.util.List;

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

		System.out.println(" START OF get() and load()");

		Department deptLoad = session.load(Department.class, 1L); // Query will not be fired as load is lazy

		System.out.println("Accessing Department name from deptLoad object: ");
		System.out.println(" dept name is " + deptLoad.getName()); // this will fire hibernate query coz load() is lazy
		System.out.println(" END OF get() and load()");

		System.out.println("Before accessing employees...");

		// Access lazy collection (triggers query now)
		System.out.println("Number of employees: " + deptLoad.getEmployees().size());
		//

		System.out.println(" START N+1 :::: ");

		List<Department> depts = session.createQuery("from Department", Department.class).list(); // One query Fired

		for (Department dept1 : depts) { // 2 Queries
			System.out.println("Department: " + dept1.getName());
			System.out.println("Number of employees: " + dept1.getEmployees().size());
		}

		System.out.println(" Fix for N+1 --->>> ");

		List<Department> depts2 = session
				.createQuery("select distinct d from Department d join fetch d.employees", Department.class).list();

		for (Department dept2 : depts2) {
			System.out.println("Department: " + dept2.getName());
			System.out.println("Number of employees: " + dept2.getEmployees().size());
		}

		txn.commit();
		session.close();

		sessionFactory.close();
	}
}
