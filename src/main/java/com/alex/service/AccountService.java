package com.alex.service;

import com.alex.model.Account;

import java.util.List;

/**
 * Created by Shishkov A.V. on 15.07.18.
 */
public interface AccountService {
	List<Account> findAll();

	Account save(Account account);
}
