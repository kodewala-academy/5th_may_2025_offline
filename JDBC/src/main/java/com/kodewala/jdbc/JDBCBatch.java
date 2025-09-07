package com.kodewala.jdbc;

import java.sql.*;

public class JDBCBatch {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch5thmay", "root", "Test@12345");

			con.setAutoCommit(false);

			ps = con.prepareStatement("INSERT INTO orders(order_id, item_name, status, placed_by) VALUES(?, ?, ?, ?)");

			// Order 1
			ps.setInt(1, 102);
			ps.setString(2, "Mobile");
			ps.setString(3, "PLACED");
			ps.setString(4, "Kodewala");
			ps.addBatch();

			// Order 2
			ps.setInt(1, 103);
			ps.setString(2, "Headphones");
			ps.setString(3, "PLACED");
			ps.setString(4, "Academy");
			ps.addBatch();

			// Order 3
			ps.setInt(1, 104);
			ps.setString(2, "Keyboard");
			ps.setString(3, "PLACED");
			ps.setString(4, "Suresh");
			ps.addBatch();

			int[] result = ps.executeBatch();
			con.commit();
			System.out.println(result.length + " orders inserted via batch.");

		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (con != null)
					con.rollback();
			} catch (Exception ex) {
			}
		} finally {
			try {
				if (ps != null)
					ps.close();
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
