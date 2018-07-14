package com.alex.repository;

import com.alex.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shishkov A.V. on 05.07.18.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
