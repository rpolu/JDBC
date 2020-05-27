package com.elegant.metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class RSMetaData {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "system";
		String password = "tiger";
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement st = con.createStatement();
		String query = "select * from account";
		ResultSet rs = st.executeQuery(query);

		ResultSetMetaData rm = rs.getMetaData();

		System.out.println(rm.getTableName(1));

		System.out.println(rm.getColumnType(1));

		System.out.println(rm.getColumnCount());

		System.out.println(rm.getColumnDisplaySize(2));

		System.out.println(rm.getColumnName(3));

		con.close();

	}

}
