package com.elegant.service;

import java.util.Scanner;

import com.elegant.dao.UserDao;
import com.elegant.model.UserModel;

public class UserService {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter the Phno");

		String phno = scanner.next();

		System.out.println("Please enter the Email");

		String email = scanner.next();

		System.out.println("Please enter the First name");
		String fname = scanner.next();

		System.out.println("Please enter the Last Name");
		String lname = scanner.next();

		System.out.println("Please enter the Address");
		String address = scanner.next();

		System.out.println("Please enter the Password");
		String pass = scanner.next();

		UserModel userModel = new UserModel();
		userModel.setPhno(phno);
		userModel.setEmail(email);
		userModel.setFirstName(fname);
		userModel.setLastName(lname);
		userModel.setAddress(address);
		userModel.setPassword(pass);

		UserDao userDao = new UserDao();
		userDao.saveUser(userModel);

		scanner.close();
		System.out.println("data saved successfully");
	}

}
