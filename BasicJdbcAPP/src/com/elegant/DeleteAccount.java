package com.elegant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteAccount {

	public static void main(String[] args) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "system";
		String password = "tiger";
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement statement = con.createStatement();

		String queryDelete = "delete from account where accnum=101";

		int row = statement.executeUpdate(queryDelete);

		System.out.println(row + " deleted");

		statement.close();
		con.close();
	}
}
