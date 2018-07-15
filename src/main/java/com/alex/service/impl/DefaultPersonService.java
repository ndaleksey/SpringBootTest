package com.alex.service.impl;

import com.alex.model.Person;
import com.alex.repository.PersonRepository;
import com.alex.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * Created by Shishkov A.V. on 05.07.18.
 */
@Service
public class DefaultPersonService implements PersonService {
	private PersonRepository repository;

	public DefaultPersonService(PersonRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Person> findAll() {
		List<Person> people = new ArrayList<>();
		StreamSupport.stream(repository.findAll().spliterator(), false).forEach(u -> people.add(u));
		return people;
	}

	@Override
	public Person findById(Long id) {
		Optional<Person> result = repository.findById(id);
		return result.isPresent() ? result.get() : null;
	}

	@Override
	public Person save(Person person) {
		return repository.save(person);
	}

	@Override
	public void saveAll(Collection<Person> persons) {
		for (Person person : persons) {
			repository.save(person);
		}
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
