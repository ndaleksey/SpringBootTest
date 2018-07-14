package com.alex.model;

import javax.persistence.*;

/**
 * Created by Shishkov A.V. on 13.07.18.
 */
@Entity
@Table(name = "network")
public class SocialNetwork {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "url", nullable = false, unique = true)
	private String url;

	public SocialNetwork() {
	}

	public SocialNetwork(String name, String url) {
		this.name = name;
		this.url = url;
	}

	/* ===== Setters/Getter ===== */

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
