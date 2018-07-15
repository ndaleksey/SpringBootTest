package com.alex.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * Created by Shishkov A.V. on 15.07.18.
 */
@Entity
public class Account {
	private static final String EMAIL_MESSAGE = "{email.message}";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank(message = EMAIL_MESSAGE)
	@Email(message = "Email должен содержать \"@\" символ")
	private String email;

	@NotEmpty(message = "Поле \"Логин\" не должно быть пустым!")
	private String login;

	@NotEmpty(message = "Поле \"Пароль\" не должно быть пустым!")
	private String password;

	public Account() {
	}

	public Account(@Email String email, @NotEmpty String login, @NotEmpty String password) {
		this.email = email;
		this.login = login;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
