package com.alex.service.impl;

import com.alex.model.User;
import com.alex.repository.UserRepository;
import com.alex.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * Created by Shishkov A.V. on 05.07.18.
 */
@Service
public class DefaultUserService implements UserService {
	private UserRepository repository;

	public DefaultUserService(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		StreamSupport.stream(repository.findAll().spliterator(), false).forEach(u -> users.add(u));
		return users;
	}

	@Override
	public User findById(Long id) {
		Optional<User> result = repository.findById(id);
		return result.isPresent() ? result.get() : null;
	}

	@Override
	public User save(User user) {
		return repository.save(user);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
