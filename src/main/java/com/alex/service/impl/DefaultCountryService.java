package com.alex.service.impl;

import com.alex.model.Country;
import com.alex.repository.CountryRepository;
import com.alex.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Shishkov A.V. on 14.07.18.
 */
@Service
public class DefaultCountryService implements CountryService {
	@Autowired
	private CountryRepository repository;

	@Override
	public long count() {
		return repository.count();
	}

	@Override
	public Country find(Long id) {
		Optional<Country> result = repository.findById(id);
		return result.isPresent() ? result.get() : null;
	}

	@Override
	public Country findByCode(String code) {
		if (code == null || code.isEmpty())
			throw new IllegalArgumentException("Задан несуществу код страны для поиска");
		return repository.findByCode(code.toUpperCase());
	}

	@Override
	public List<Country> findAll() {
		return repository.findAll();
	}

	@Override
	public Country save(Country country) {
		return repository.save(country);
	}
}
