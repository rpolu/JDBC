package com.elegant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestAccount {

	public static void main(String[] args) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "system";
		String password = "tiger";

		Connection con = DriverManager.getConnection(url, userName, password);

		String insertQuery = "insert into account values(101,'rama' ,9000)";

		Statement st = con.createStatement();

		int row = st.executeUpdate(insertQuery);

		System.out.println(row + " row inserted sucessfully");

		st.close();
		con.close();

	}
}
