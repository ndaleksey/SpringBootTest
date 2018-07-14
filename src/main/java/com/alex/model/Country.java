package com.alex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Shishkov A.V. on 13.07.18.
 */
@Entity
public class Country {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Column(name = "code", unique = true, nullable = false)
	private String code;

	public Country() {
	}

	public Country(String name, String code) {
		this.name = name;
		this.code = code;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
