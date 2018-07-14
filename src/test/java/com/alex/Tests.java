package com.alex;

import com.alex.model.Person;
import com.alex.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Created by Shishkov A.V. on 05.07.18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class Tests {
	@Autowired
	private PersonService personService;


	@Test
	public void deleteUserWithDefaultUserService() {
//		Person nina = personService.save(new Person("Nina", "UK"));
//		Account account = accountService.save(new Account(nina, "nana", "123", "Deuche Bank", "1"));

		List<Person> people = personService.findAll();
		Person person = people.get(0);
		personService.delete(person.getId());
		System.out.print("\nУдалено\n");
		person = personService.findById(person.getId());
		assertNull(person, "Person was not deleted");
	}

	/*@Test
	public void deleteAccountWithDefaultAccountService() {
		List<Account> accounts = accountService.findAll();
		Account account = accounts.get(0);
		accountService.delete(account.getId());
		Person user = personService.findById(account.getPerson().getId());
		assertNotNull(user, "Person was deleted");
	}*/


}
