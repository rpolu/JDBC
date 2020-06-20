package com.elegant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertPrepareApp1 {

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

		pst.setInt(1, 11);
		pst.setString(2, "anup");
		pst.setFloat(3, 9000.80f);
		pst.addBatch();

		pst.setInt(1, 12);
		pst.setString(2, "nakul");
		pst.setFloat(3, 10000.80f);
		pst.addBatch();

		pst.setInt(1, 13);
		pst.setString(2, "sachin");
		pst.setFloat(3, 11000.80f);
		pst.addBatch();

		int[] arr1 = pst.executeBatch();

		pst.setInt(1, 21);
		pst.setString(2, "thulasi");
		pst.setFloat(3, 9000.80f);
		pst.addBatch();

		pst.setInt(1, 22);
		pst.setString(2, "sujana");
		pst.setFloat(3, 10000.80f);
		pst.addBatch();

		pst.setInt(1, 23);
		pst.setString(2, "supraja");
		pst.setFloat(3, 11000.80f);
		pst.addBatch();

		int[] arr2 = pst.executeBatch();

		System.out.println(arr1.length + arr2.length + " : rows inserted");

		pst.close();
		con.close();

	}

}
