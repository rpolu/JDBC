package com.elegant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcAPP {
	public static void main(String[] args) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		// Load the diver class.
		// Register Driver class with DriverManager

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "system";
		String password = "tiger";

		Connection con = DriverManager.getConnection(url, userName, password);
		
		
		Statement st = con.createStatement();
		
		String query = "insert into student values(101,'rama')";
		int row = st.executeUpdate(query);
		System.out.println(row + " inserted");
		
		
		st.close();
		con.close();// Need to close the connection object

	}
}
