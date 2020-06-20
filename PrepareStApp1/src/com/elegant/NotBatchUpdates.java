package com.elegant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class NotBatchUpdates {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// Load the diver class and creating the object.
		// Register Driver class with DriverManager

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "system";
		String password = "tiger";

		Connection con = DriverManager.getConnection(url, userName, password);
		String insertquery = "insert into account values(?,?,?)";

		PreparedStatement pst = con.prepareStatement(insertquery);

		pst.setInt(1, 1);
		pst.setString(2, "rama1");
		pst.setFloat(3, 9000.80f);
		int row1 = pst.executeUpdate();

		pst.setInt(1, 2);
		pst.setString(2, "rama2");
		pst.setFloat(3, 10000.80f);
		int row2 = pst.executeUpdate();

		pst.setInt(1, 3);
		pst.setString(2, "rama3");
		pst.setFloat(3, 11000.80f);
		int row3 = pst.executeUpdate();

		System.out.println(row1 + row2 + row3 + " : rows inserted");
		pst.close();
		con.close();

	}

}