package com.alex.controller;

import com.alex.model.Person;
import com.alex.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by Shishkov A.V. on 12.07.18.
 */
@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private PersonService personService;

	@ModelAttribute
	public void populateWithAttributes(Model model) {
		model.addAttribute("users", personService.findAll());
		model.addAttribute("user", new Person());
	}

	@GetMapping
	public String showAllUser() {
		return "users";
	}

	@PostMapping("/find")
	public String findUser(@ModelAttribute("user") final Person person, @ModelAttribute("users") final List<Person> people, Model model) {
		Optional<Person> optResult = people.stream().filter(u -> u.getName().equalsIgnoreCase(person.getName())).findFirst();
		Person result = optResult.isPresent() ? optResult.get() : null;
		model.addAttribute("user", result);
		return "user";
	}

	@GetMapping("/{id}/accounts")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Long[] getAccountsByUserId(@PathVariable("id") Long id) {
		Person person = personService.findById(id);

		/*List<Long> ids = person.getAccounts().stream().map(a -> a.getId()).collect(Collectors.toList());
		return ids.toArray(new Long[ids.size()]);*/
		return null;
	}

	/*@GetMapping("/user")
	public String showUser(Model model) {
		return "user";
	}*/
}
