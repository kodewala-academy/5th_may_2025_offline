package com.kodewala.transactiondemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String holderName;
	private Double balance;

	// 🔹 Default constructor
	public Account() {
	}

	// 🔹 Parameterized constructor
	public Account(Long id, String holderName, Double balance) {
		this.id = id;
		this.holderName = holderName;
		this.balance = balance;
	}

	// 🔹 Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	// 🔹 toString() for logging/debugging
	@Override
	public String toString() {
		return "Account{" + "id=" + id + ", holderName='" + holderName + '\'' + ", balance=" + balance + '}';
	}
}
