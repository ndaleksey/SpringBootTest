package com.alex.service.impl;

import com.alex.model.Account;
import com.alex.repository.AccountRepository;
import com.alex.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shishkov A.V. on 15.07.18.
 */
@Service
public class DefaultAccountService implements AccountService {
	@Autowired
	private AccountRepository repository;

	@Override
	public List<Account> findAll() {
		return repository.findAll();
	}

	@Override
	public Account save(Account account) {
		return repository.save(account);
	}
}
