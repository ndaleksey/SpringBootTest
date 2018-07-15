package com.alex.service;

import com.alex.model.Country;

import java.util.List;

/**
 * Created by Shishkov A.V. on 14.07.18.
 */
public interface CountryService {
	long count();

	Country find(Long id);

	Country findByCode(String code);

	List<Country> findAll();

	Country save(Country country);
}