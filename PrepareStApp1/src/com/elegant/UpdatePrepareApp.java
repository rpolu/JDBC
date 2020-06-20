package com.elegant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdatePrepareApp {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// Load the diver class and creating the object.
		// Register Driver class with DriverManager
        
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "system";
		String password = "tiger";

		Connection con = DriverManager.getConnection(url, userName, password);
		String insertquery = "update  account set BALANCE = BALANCE + ? where ACCNUM = ? ";

		PreparedStatement pst = con.prepareStatement(insertquery);
		pst.setFloat(1, 2000.90f);
        pst.setInt(2, 101);
		

		int row = pst.executeUpdate();
		System.out.println(row + " : rows Updated");
		pst.close();
		con.close();

	}

}
