package com.elegant.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class TestTransaction {
	public static void main(String[] args) throws Exception {

		Connection con = null;
		Statement st = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String userName = "system";
			String password = "tiger";
			con = DriverManager.getConnection(url, userName, password);
			con.setAutoCommit(false);

			st = con.createStatement();

			String query1 = "update account  set balance =balance-5000  where accnum=2";
			String query2 = "update account  set balance =balance+5000  wher accnum=1";

			st.executeUpdate(query1);
			st.executeUpdate(query2);

			con.commit();
			System.out.println("Transaction completede");
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		} finally {
			st.close();
			con.close();
		}

	}
}
