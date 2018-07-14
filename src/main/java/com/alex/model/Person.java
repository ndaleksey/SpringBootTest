package com.alex.model;

import javax.persistence.*;

/**
 * Created by Shishkov A.V. on 05.07.18.
 */
@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@ManyToOne
	private Country country;

	private int age;

	@Enumerated
	private Gender gender;

	/*@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "person", fetch = FetchType.EAGER)
	private Set<Account> accounts = new HashSet<>();*/

	public Person() {
	}

	public Person(String name, Country country) {
		this.name = name;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	/*public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}*/
}
