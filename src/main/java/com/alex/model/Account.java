package com.alex.model;

import javax.persistence.*;

/**
 * Created by Shishkov A.V. on 12.05.18.
 */
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String account;

	/**
	 * IBAN
	 */
	private String bankAccountNumber;
	private String bankName;
	/**
	 * BIC
	 */
	private String bankIdCode;

	private boolean isChecked;

	@ManyToOne
	private User user;

	public Account() {
	}

	public Account(User user,  String account, String bankAccountNumber, String bankName, String bankIdCode) {
		this.user = user;
		this.account = account;
		this.bankAccountNumber = bankAccountNumber;
		this.bankName = bankName;
		this.bankIdCode = bankIdCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankIdCode() {
		return bankIdCode;
	}

	public void setBankIdCode(String bankIdCode) {
		this.bankIdCode = bankIdCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean checked) {
		isChecked = checked;
	}
}