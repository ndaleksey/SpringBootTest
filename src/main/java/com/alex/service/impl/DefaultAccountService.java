package com.alex.service.impl;

import com.alex.model.Account;
import com.alex.model.User;
import com.alex.repository.AccountRepository;
import com.alex.repository.UserRepository;
import com.alex.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

/**
 * Created by Shishkov A.V. on 12.05.18.
 */
@Service
public class DefaultAccountService implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	private void addInitialAccounts() {
		User alex = userRepository.save(new User("Alex", "Russia"));
		User simon = userRepository.save(new User("Simon", "Russia"));

		save(new Account(alex, "123", "1123", "Bank of America", "1"));
		save(new Account(alex, "12-33", "21 23", "Deutsche Bank", "2"));
		save(new Account(simon, "12-35", "21 25", "Deutsche Bank", "2"));
		save(new Account(simon, "12-36", "21 26", "Deutsche Bank", "2"));
	}

	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		accountRepository.deleteById(id);
	}

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account findById(Long id) {
		Optional<Account> result = accountRepository.findById(id);
		return result.isPresent() ? result.get() : null;
	}
}
