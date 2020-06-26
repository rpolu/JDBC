package com.service;

import com.person.dao.PersonDao;

public class ServiceTestDelete {

	public static void main(String[] args) throws Exception {
		PersonDao personDao = new PersonDao();

		personDao.deletePerson("999999");

		System.out.println(" Delete success");
	}

}
