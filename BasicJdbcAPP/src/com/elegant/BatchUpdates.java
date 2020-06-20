package com.elegant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class BatchUpdates {
	public static void main(String[] args) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "system";
		String password = "tiger";

		Connection con = DriverManager.getConnection(url, userName, password);

		String insertQuery1 = "insert into account values(111,'sahchin' ,9000)";
		String insertQuery2 = "insert into account values(112,'anup' ,9000)";
		String insertQuery3 = "insert into account values(113,'nakul' ,9000)";

		Statement st = con.createStatement();

		st.addBatch(insertQuery1);
		st.addBatch(insertQuery2);
		st.addBatch(insertQuery3);

		int[] rows = st.executeBatch();

		System.out.println(rows.length + " row inserted sucessfully");

		st.close();
		con.close();

	}
}
