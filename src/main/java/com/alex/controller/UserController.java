package com.alex.controller;

import com.alex.model.User;
import com.alex.service.AccountService;
import com.alex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Shishkov A.V. on 12.07.18.
 */
@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private AccountService accountService;

	@ModelAttribute
	public void populateWithAttributes(Model model) {
		model.addAttribute("users", userService.findAll());
		model.addAttribute("user", new User());
		model.addAttribute("accounts", accountService.findAll());
	}

	@GetMapping
	public String showAllUser() {
		return "users";
	}

	@PostMapping("/find")
	public String findUser(@ModelAttribute("user") final User user, @ModelAttribute("users") final List<User> users, Model model) {
		Optional<User> optResult = users.stream().filter(u -> u.getName().equalsIgnoreCase(user.getName())).findFirst();
		User result = optResult.isPresent() ? optResult.get() : null;
		model.addAttribute("user", result);
		return "user";
	}

	@GetMapping("/{id}/accounts")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Long[] getAccountsByUserId(@PathVariable("id") Long id) {
		User user = userService.findById(id);

		List<Long> ids = user.getAccounts().stream().map(a -> a.getId()).collect(Collectors.toList());
		return ids.toArray(new Long[ids.size()]);
	}

	/*@GetMapping("/user")
	public String showUser(Model model) {
		return "user";
	}*/
}
