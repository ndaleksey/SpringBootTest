package com.alex.controller;

import com.alex.model.Account;
import com.alex.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Shishkov A.V. on 15.07.18.
 */
@Controller
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@ModelAttribute
	public void initModel(Model model) {
		model.addAttribute("account", new Account());
	}

	@GetMapping
	public String showAllAccount(Model model) {
		model.addAttribute("accounts", accountService.findAll());
		return "accounts";
	}

	@GetMapping("/sign_up")
	public String showRegistrationForm() {
		return "account_registration";
	}

	@PostMapping("/sign_up")
	public String showRegistrationResult(@Valid @ModelAttribute Account account, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) return "account_registration";
		

		accountService.save(account);

		return "index";
	}

}
