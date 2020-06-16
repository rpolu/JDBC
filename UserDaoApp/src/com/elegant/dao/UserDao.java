package com.elegant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.elegant.model.UserModel;

public class UserDao {
	private static final String DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USERNAME = "system";
	private static final String PASSWORD = "tiger";
	private static final String INSERT_DATA = "INSERT INTO USERS_APP VALUES(?,?,?,?,?,?)";

	public void saveUser(UserModel um) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName(DRIVER_CLASS);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pst = con.prepareStatement(INSERT_DATA);
			pst.setString(1, um.getPhno());
			pst.setString(2, um.getEmail());
			pst.setString(3, um.getFirstName());
			pst.setString(4, um.getLastName());
			pst.setString(5, um.getAddress());
			pst.setString(6, um.getPassword());
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
