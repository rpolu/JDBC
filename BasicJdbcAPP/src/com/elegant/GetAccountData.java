package com.elegant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetAccountData {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "system";
		String password = "tiger";
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement st = con.createStatement();
		String query = "select * from account";
		
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			int accnum = rs.getInt(1);
			String name = rs.getString(2);
			float bal = rs.getFloat(3);
			System.out.println(accnum + " " + name + " " + bal);
		}
		
		rs.close();
		st.close();
		con.close();

	}
}
