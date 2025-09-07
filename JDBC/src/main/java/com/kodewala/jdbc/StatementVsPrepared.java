package com.kodewala.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StatementVsPrepared {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch5thmay", "root", "Test@12345");

			// Example 1: Using Statement
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM orders WHERE placed_by = 'Ajay'");
			System.out.println("Orders by Ajay (Statement):");
			while (rs.next()) {
				System.out.println(rs.getInt("order_id") + " | " + rs.getString("item_name"));
			}
			rs.close();

			// Example 2: Using PreparedStatement with Suresh
			ps = con.prepareStatement("SELECT * FROM orders WHERE placed_by = ?");
			ps.setString(1, "Suresh"); // changed from Bob → Suresh
			rs = ps.executeQuery();
			System.out.println("Orders by Suresh (PreparedStatement):");
			while (rs.next()) {
				System.out.println(rs.getInt("order_id") + " | " + rs.getString("item_name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (ps != null)
					ps.close();
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
