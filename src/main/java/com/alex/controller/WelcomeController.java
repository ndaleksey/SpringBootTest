package com.alex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Shishkov A.V. on 15.07.18.
 */
@Controller
@RequestMapping(value = {"/", "/index"})
public class WelcomeController {
	@GetMapping
	public String showIndexPage() {
		return "index";
	}
}
