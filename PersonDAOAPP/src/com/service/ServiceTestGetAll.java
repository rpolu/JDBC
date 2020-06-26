package com.service;

import com.person.dao.PersonDao;
import com.person.model.PersonModel;

public class ServiceTestGetAll {

	public static void main(String[] args) throws Exception {
		PersonDao personDao = new PersonDao();

		PersonModel pm = personDao.getPerson("999999");

		System.out.println(pm.getPhno());
		System.out.println(pm.getFirstName());
		System.out.println(pm.getLastName());
		System.out.println(pm.getEmail());
		System.out.println(pm.getAddress());

	}

}
