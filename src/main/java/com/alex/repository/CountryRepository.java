package com.alex.repository;

import com.alex.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Shishkov A.V. on 13.07.18.
 */
public interface CountryRepository extends JpaRepository<Country, Long> {
}
