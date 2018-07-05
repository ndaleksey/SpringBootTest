package com.alex.controller;

import com.alex.model.Account;
import com.alex.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Shishkov A.V. on 12.05.18.
 */
@Controller
@RequestMapping(path = "/accounts")
public class AccountController {
	@Autowired
	AccountService service;

	@GetMapping(path = "")
	public String showAccounts(Model model) {
		List<Account> accounts = service.findAll();
		model.addAttribute("accounts", accounts);
		return "accounts";
	}

	@GetMapping(path = "/all")
	@ResponseBody
	public List<Account> findAll() {
		return service.findAll();
	}
}
