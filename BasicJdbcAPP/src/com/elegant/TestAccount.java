package com.elegant;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestAccount {

	public static void main(String[] args) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "system";
		String password = "tiger";

		Connection connection = DriverManager.getConnection(url, username, password);
		
		Statement st = connection.createStatement();
		System.out.println(st);
		String query_insert = "insert into account values(3,'Haitha',8000)";

		int row = st.executeUpdate(query_insert);

		System.out.println(row + " row inserted in DB.");
		st.close();
		connection.close();

	}
}
