package com.elegant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertDoubleAccount {

	public static void main(String[] args) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "system";
		String password = "tiger";

		Connection con = DriverManager.getConnection(url, userName, password);

		String insertQuery1 = "insert into account values(103,'XYZ' ,4000)";
		String insertQuery2 = "insert into account values(104,'ABC' ,5000)";

		Statement st = con.createStatement();

		st.executeUpdate(insertQuery1);
		st.executeUpdate(insertQuery2);

		System.out.println("inserted sucessfully");

		st.close();
		con.close();

	}
}
