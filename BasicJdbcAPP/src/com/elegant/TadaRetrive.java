package com.elegant;
import java.sql.*;
public class TadaRetrive {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "system";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement st = conn.createStatement();
		String query = "select * from users where userid='101'";

		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {
			String fname = rs.getString(2);
			String lname = rs.getString(3);
			String address = rs.getString(4);
			System.out.println(fname + " " + lname + " " + address);
		}
		rs.close();
		st.close();
		conn.close();

	}
}
