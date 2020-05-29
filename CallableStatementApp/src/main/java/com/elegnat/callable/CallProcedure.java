package com.elegnat.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallProcedure {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// Load the diver class.
		// Register Driver class with DriverManager

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "system";
		String password = "tiger";

		Connection con = DriverManager.getConnection(url, userName, password);

		String callProcedure = "{call insertData(?,?,?)}";
		CallableStatement cst = con.prepareCall(callProcedure);
		cst.setInt(1, 101);
		cst.setString(2, "haritha");
		cst.setFloat(3, 9000);

		cst.execute();

		System.out.println("Procedure invoked");
		cst.close();
		con.close();

	}

}
