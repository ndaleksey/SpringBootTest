package com.alex.service;

import com.alex.model.User;

import java.util.List;

/**
 * Created by Shishkov A.V. on 05.07.18.
 */
public interface UserService {
	List<User> findAll();

	User findById(Long id);

	User save(User user);

	void delete(Long id);
}
