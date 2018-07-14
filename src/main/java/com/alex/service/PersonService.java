package com.alex.service;

import com.alex.model.Person;

import java.util.List;

/**
 * Created by Shishkov A.V. on 05.07.18.
 */
public interface PersonService {
	List<Person> findAll();

	Person findById(Long id);

	Person save(Person person);

	void delete(Long id);
}