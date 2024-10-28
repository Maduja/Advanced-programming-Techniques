package com.classes;

import java.sql.*;

public class DbConnector {
	private static String URL="jdbc:mysql://localhost:3306/activity01";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String DBUSER="xyz";
	private static String DBPW="xyz";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, DBUSER, DBPW);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	
	
}
