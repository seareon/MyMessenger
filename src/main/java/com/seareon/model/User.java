package com.seareon.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="login")
	private String login = null;
	
	@Column(name = "password")
	private String password = null;
	
	@Column(name = "email")
	private String email = null;
	
	@OneToOne(mappedBy = "user")
	private Profile profile;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setProfile (Profile profile) {
		this.profile = profile;
	}
	
	public Profile getProfile() {
		return profile;
	}
}
