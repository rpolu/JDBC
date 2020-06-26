package com.service;

import com.person.dao.PersonDao;
import com.person.model.PersonModel;

public class ServiceTestUpdate {

	public static void main(String[] args) throws Exception {
		PersonDao personDao = new PersonDao();
		PersonModel personModel = new PersonModel();

		personModel.setPhno("999999");
		personModel.setEmail("xyz@gmail.com");
		personModel.setAddress("Banagalore");

		personDao.updatePerson(personModel);

		System.out.println(" Update success");
	}

}
