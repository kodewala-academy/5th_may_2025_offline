package com.kodewala.jdbc;

import java.sql.*;

public class JDBCTransaction {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement psPayment = null;
		PreparedStatement psOrder = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch5thmay", "root", "Test@12345");

			// Step 1: Disable auto-commit
			con.setAutoCommit(false);

			// Step 2: Insert into payment
			psPayment = con.prepareStatement("INSERT INTO payment(payment_id, amount, status) VALUES(?, ?, ?)");
			psPayment.setInt(1, 2);
			psPayment.setInt(2, 1000);
			psPayment.setString(3, "SUCCESS");
			psPayment.executeUpdate();

			// Step 3: Insert into orders
			psOrder = con
					.prepareStatement("INSERT INTO orders(order_id, item_name, status, placed_by) VALUES(?, ?, ?, ?)");
			psOrder.setInt(1, 101);
			psOrder.setString(2, "Laptop");
			psOrder.setString(3, "PLACED");
			psOrder.setString(4, "Suresh");
			psOrder.executeUpdate();

			// Step 4: Commit
			con.commit();
			System.out.println("Transaction committed.");

		} catch (Exception e) {
			System.out.println("Error occurred: " + e.getMessage());
			try {
				if (con != null)
					con.rollback();
			} catch (Exception ex) {
			}
		} finally {
			// Step 5: Close resources
			try {
				if (psOrder != null)
					psOrder.close();
			} catch (Exception e) {
			}
			try {
				if (psPayment != null)
					psPayment.close();
			} catch (Exception e) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
	}
}
