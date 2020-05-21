package com.elegant;
import java.sql.*;
public class GetAllStudents {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String userName = "system";
			String password = "tiger";
			conn = DriverManager.getConnection(url, userName, password);

			String row_query = "select * from student where rollnum= ?";
			pst = conn.prepareStatement(row_query);
			pst.setInt(1, 103);
			rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
