package com.alex;

import com.alex.model.Account;
import com.alex.model.User;
import com.alex.service.AccountService;
import com.alex.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Created by Shishkov A.V. on 05.07.18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class Tests {
	@Autowired
	private UserService userService;

	@Autowired
	private AccountService accountService;

	@Test
	public void deleteUserWithDefaultUserService() {
//		User nina = userService.save(new User("Nina", "UK"));
//		Account account = accountService.save(new Account(nina, "nana", "123", "Deuche Bank", "1"));

		List<User> users = userService.findAll();
		User user = users.get(0);
		userService.delete(user.getId());
		System.out.print("\nУдалено\n");
		user = userService.findById(user.getId());
		assertNull(user, "User was not deleted");
	}

	/*@Test
	public void deleteAccountWithDefaultAccountService() {
		List<Account> accounts = accountService.findAll();
		Account account = accounts.get(0);
		accountService.delete(account.getId());
		User user = userService.findById(account.getUser().getId());
		assertNotNull(user, "User was deleted");
	}*/

	@Test
	public void deleteAccountWithDefaultAccountService() {
		List<Account> accounts = accountService.findAll();
		Account account = accounts.get(0);
		accountService.delete(account.getId());
		account = accountService.findById(account.getId());
		assertNull(account, "Account was not deleted!");
	}

	@Test
	public void deleteAccountNotDeleteUser() {
		List<Account> accounts = accountService.findAll();
		Account account = accounts.get(0);
		User user = account.getUser();
		accountService.delete(account.getId());
		user = userService.findById(user.getId());
		assertNotNull(user, "User was deleted when Account has been deleted");
	}
}
