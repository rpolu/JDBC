package com.elegant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateAccount {

	public static void main(String[] args) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "system";
		String password = "tiger";
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement statement = con.createStatement();

		String query = "update account set BALANCE=BALANCE+1000 where accnum=102";

		int rows = statement.executeUpdate(query);

		System.out.println(rows + " rows updated");
		statement.close();
		con.close();

	}
}
