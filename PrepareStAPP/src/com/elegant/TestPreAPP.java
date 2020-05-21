package com.elegant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class TestPreAPP {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String userName = "system";
			String password = "tiger";

			Connection con = DriverManager.getConnection(url, userName, password);
			String insert_data = "insert into student values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(insert_data);
			
			
			pst.setInt(1, 103);
			pst.setString(2, "Nandha");
			pst.setInt(3, 96);
			pst.setString(4, "Bangalore");
			int row1 = pst.executeUpdate();
			
			pst.setInt(1, 102);
			pst.setString(2, "Haritah");
			pst.setInt(3, 95);
			pst.setString(4, "Kerala");
			int row2 = pst.executeUpdate();

			System.out.println(row1+row2 + " Inserted");
			pst.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
