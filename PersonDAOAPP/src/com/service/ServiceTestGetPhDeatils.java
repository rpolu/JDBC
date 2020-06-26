package com.service;

import java.util.List;

import com.person.dao.PersonDao;
import com.person.model.PersonModel;

public class ServiceTestGetPhDeatils {

	public static void main(String[] args) throws Exception {
		PersonDao personDao = new PersonDao();

		List<PersonModel> pl = personDao.getAllPersons();
		for (PersonModel pm : pl) {
			System.out.println(pm.getPhno());
			System.out.println(pm.getFirstName());
			System.out.println(pm.getLastName());
			System.out.println(pm.getEmail());
			System.out.println(pm.getAddress());
			
			System.out.println("________________________-");
		}

	}

}
