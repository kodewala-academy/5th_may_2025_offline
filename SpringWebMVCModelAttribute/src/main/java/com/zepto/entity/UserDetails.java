package com.zepto.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.zepto.order.entity.OrderDetails;

@Entity
@Table(name = "user_details")
public class UserDetails {

	@Id
	private String userName;
	private String firstName;
	private String lastName;
	private String status;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private OrderDetails order;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OrderDetails getOrder() {
		return order;
	}

	public void setOrder(OrderDetails order) {
		this.order = order;
		order.setUser(this); // keep bidirectional consistency
	}
}
