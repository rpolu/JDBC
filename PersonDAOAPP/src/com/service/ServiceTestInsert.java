package com.service;

import com.person.dao.PersonDao;
import com.person.model.PersonModel;

public class ServiceTestInsert {

	public static void main(String[] args) throws Exception {
		PersonDao personDao = new PersonDao();
		PersonModel personModel = new PersonModel();
		personModel.setFirstName("rama");
		personModel.setLastName("mohan");
		personModel.setPhno("999999");
		personModel.setEmail("abc@gmail.com");
		personModel.setAddress("kadapa");

		personDao.savePerson(personModel);

		System.out.println(" Saved success");
	}

}
