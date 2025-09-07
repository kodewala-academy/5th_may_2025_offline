package com.kodewala.jdbc;

import java.sql.*;

public class SimpleJDBC {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// Step 1: Load driver (optional for new JDBC versions)
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 2: Get connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch5thmay", "root", "Test@12345");

			// Step 3: Create statement
			stmt = con.createStatement();

			// Step 4: Insert into payment table
			String insertQuery = "INSERT INTO payment(payment_id, amount, status) VALUES(1, 500, 'SUCCESS')";
			int rows = stmt.executeUpdate(insertQuery);
			System.out.println(rows + " row inserted.");

			// Step 5: Select data
			rs = stmt.executeQuery("SELECT * FROM payment");
			while (rs.next()) {
				System.out.println(
						rs.getInt("payment_id") + " | " + rs.getInt("amount") + " | " + rs.getString("status"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Step 6: Close resources in reverse order
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (stmt != null)
					stmt.close();
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
