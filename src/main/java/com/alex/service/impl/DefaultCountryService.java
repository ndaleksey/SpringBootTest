package com.alex.service.impl;

import com.alex.model.Country;
import com.alex.repository.CountryRepository;
import com.alex.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Shishkov A.V. on 14.07.18.
 */
@Service
public class DefaultCountryService implements CountryService {
	@Autowired
	private CountryRepository repository;

	@Override
	public Country save(Country country) {
		return repository.save(country);
	}
}
