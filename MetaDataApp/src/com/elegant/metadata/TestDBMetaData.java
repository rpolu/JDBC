package com.elegant.metadata;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
public class TestDBMetaData {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// Load the diver class.
		// Register Driver class with DriverManager

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "system";
		String password = "tiger";

		Connection con = DriverManager.getConnection(url, userName, password);

		DatabaseMetaData dm = con.getMetaData();
		
		
		System.out.println(dm.getDatabaseMajorVersion());
		
		System.out.println(dm.getDatabaseProductName());
		
		
		System.out.println(dm.getDriverName());
		
		
		System.out.println(dm.getUserName());
		
		System.out.println(dm.getURL());
		
      con.close();
	}
}
