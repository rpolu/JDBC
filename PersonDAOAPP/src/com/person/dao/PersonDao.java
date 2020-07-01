package com.person.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.person.model.PersonModel;

public class PersonDao {

	private final String QUERY = "INSERT INTO PERSON_APP VALUES(?,?,?,?,?)";
	private final String DELETEQUERY = "DELETE FROM PERSON_APP WHERE PHNO=?";
	private final String UPDATE_QUERY = "UPDATE PERSON_APP SET EMAIL= ? ,ADDRESS  = ? WHERE PHNO = ?";
	private final String GET_PERSON_QUERY = "SELECT * FROM PERSON_APP WHERE PHNO=?";
	private final String GET_PERSONS = "SELECT * FROM PERSON_APP";

	public void savePerson(PersonModel personModel) throws Exception {
		Connection con = ConnectionsUtils.getConnection();
		PreparedStatement pst = con.prepareStatement(QUERY);

		pst.setString(1, personModel.getFirstName());
		pst.setString(2, personModel.getLastName());
		pst.setString(3, personModel.getPhno());
		pst.setString(4, personModel.getEmail());
		pst.setString(5, personModel.getAddress());

		pst.executeUpdate();
		pst.close();
		ConnectionsUtils.closeConnection();

	}

	public void deletePerson(String phno) throws Exception {
		Connection con = ConnectionsUtils.getConnection();
		PreparedStatement pst = con.prepareStatement(DELETEQUERY);
		pst.setString(1, phno);
		pst.executeUpdate();
		pst.close();
		ConnectionsUtils.closeConnection();
	}

	public void updatePerson(PersonModel personModel) throws Exception {
		Connection con = ConnectionsUtils.getConnection();
		PreparedStatement pst = con.prepareStatement(UPDATE_QUERY);
		pst.setString(1, personModel.getEmail());
		pst.setString(2, personModel.getAddress());
		pst.setString(3, personModel.getPhno());
		pst.executeUpdate();
		pst.close();
		ConnectionsUtils.closeConnection();
	}

	public List<PersonModel> getAllPersons() throws Exception {
		Connection con = ConnectionsUtils.getConnection();
		PreparedStatement pst = con.prepareStatement(GET_PERSONS);
		ResultSet rs = pst.executeQuery();
		List<PersonModel> al = new ArrayList<PersonModel>();

		while (rs.next()) {
			PersonModel personModel = new PersonModel();
			personModel.setFirstName(rs.getString(1));
			personModel.setLastName(rs.getString(2));
			personModel.setPhno(rs.getString(3));
			personModel.setEmail(rs.getString(4));
			personModel.setAddress(rs.getString(5));
			al.add(personModel);
		}
		rs.close();
		pst.close();
		ConnectionsUtils.closeConnection();
		return al;
	}

	public PersonModel getPerson(String phno) throws Exception {
		Connection con = ConnectionsUtils.getConnection();
		PreparedStatement pst = con.prepareStatement(GET_PERSON_QUERY);
		pst.setString(1, phno);
		ResultSet rs = pst.executeQuery();

		PersonModel personModel = new PersonModel();
		while (rs.next()) {
			personModel.setFirstName(rs.getString(1));
			personModel.setLastName(rs.getString(2));
			personModel.setPhno(rs.getString(3));
			personModel.setEmail(rs.getString(4));
			personModel.setAddress(rs.getString(5));
		}
		rs.close();
		pst.close();
		ConnectionsUtils.closeConnection();
		return personModel;
	}

}
