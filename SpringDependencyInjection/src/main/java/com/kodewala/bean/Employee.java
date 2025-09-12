package com.kodewala.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {

	private String name;
	private Address addressConstructor;	
	private Address addressSetter;
	
	@Autowired
	private Address addressField;
	// Constructor Injection
	public Employee(Address addressConstructor) {
		this.addressConstructor = addressConstructor;
		this.name = "Constructor Employee";
	}
	// Setter Injection
	@Autowired
	public void setAddressSetter(Address addressSetter) {
		this.addressSetter = addressSetter;
	}

	// Field Injection already handled by @Autowired

	public void showEmployeeDetails() {
		System.out.println("=== Constructor Injection ===");
		System.out.println("Name: " + name);
		System.out.println("Address: " + addressConstructor.getCity() + ", " + addressConstructor.getState());

		System.out.println("=== Setter Injection ===");
		System.out.println("Name: Setter Employee");
		System.out.println("Address: " + addressSetter.getCity() + ", " + addressSetter.getState());

		System.out.println("=== Field Injection ===");
		System.out.println("Name: Field Employee");
		System.out.println("Address: " + addressField.getCity() + ", " + addressField.getState());
	}
}
