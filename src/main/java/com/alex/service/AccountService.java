package com.alex.service;

import com.alex.model.Account;

import java.util.List;

/**
 * Created by Shishkov A.V. on 12.05.18.
 */
public interface AccountService {
	Account save(Account account);

	void delete(Long id);

	List<Account> findAll();

	Account findById(Long id);
}
