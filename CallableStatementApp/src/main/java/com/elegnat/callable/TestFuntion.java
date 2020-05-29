package com.elegnat.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class TestFuntion {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// Load the diver class.
		// Register Driver class with DriverManager

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "system";
		String password = "tiger";

		Connection con = DriverManager.getConnection(url, userName, password);

		String queryFunction = "{? = call manpulate(?,?)}";
		CallableStatement cst = con.prepareCall(queryFunction);
		cst.registerOutParameter(1, Types.INTEGER);
		cst.setInt(2, 10);
		cst.setInt(3, 20);
		cst.execute();

		System.out.println(cst.getInt(1));

		cst.close();
		con.close();

	}

}
