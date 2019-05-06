package com.jalor.others;

import java.sql.Connection;

public class DriverManager {

	private static Connection getConn() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/samp_db";
		String username = "root";
		String password = "";
		Connection conn = null;
		// try {
		// Class.forName(driver); //classLoader,加载对应驱动
		// conn = (Connection) DriverManager.getConnection(url, username,
		// password);
		// } catch (ClassNotFoundException e) {
		// e.printStackTrace();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		return conn;
	}

}
