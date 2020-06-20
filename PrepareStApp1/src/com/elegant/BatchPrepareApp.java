package com.elegant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BatchPrepareApp {

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

		pst.setInt(1, 101);
		pst.setString(2, "KKKK");
		pst.setFloat(3, 8000.89f);

		int row = pst.executeUpdate();
		System.out.println(row + " : rows inserted");
		pst.close();
		con.close();

	}

}
