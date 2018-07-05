package com.alex.repository;

import com.alex.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shishkov A.V. on 12.05.18.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
