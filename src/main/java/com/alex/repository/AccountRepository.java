package com.alex.repository;

import com.alex.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shishkov A.V. on 15.07.18.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	/*@Query()
	Integer count*/
}
