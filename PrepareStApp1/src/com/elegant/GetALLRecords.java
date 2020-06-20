package com.elegant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetALLRecords {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String userName = "system";
			String password = "tiger";
			con = DriverManager.getConnection(url, userName, password);
			String query = "SELECT * FROM ACCOUNT";
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				int accnum = rs.getInt("ACCNUM");
				String name = rs.getString("HOLDER_NAME");
				float bal = rs.getFloat("BALANCE");
				System.out.println(accnum + " " + name + " " + bal);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

}
