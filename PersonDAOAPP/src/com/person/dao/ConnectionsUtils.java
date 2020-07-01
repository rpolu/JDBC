package com.person.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionsUtils {
	private static final String ORACLE_JDBC_DRIVER_ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String UN = "system";
	private static final String PS = "tiger";
	private static Connection con;

	public static Connection getConnection() {
		try {
			Class.forName(ORACLE_JDBC_DRIVER_ORACLE_DRIVER);
			con = DriverManager.getConnection(URL, UN, PS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
