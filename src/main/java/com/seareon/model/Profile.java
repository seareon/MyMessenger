package com.seareon.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "profile")
public class Profile {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "age")
	private String age;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "country")
	private String country;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	User user;

	@OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "profile")
	@OrderBy(value = "date")
	private Set<Post> posts = new HashSet<Post>();
	
	@OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "subscribers")
	private Set<Profile> subscribers = new HashSet<Profile>();
	
	@Transactional(readOnly = true)
	public Set<Profile> getSubscribers() {
		return subscribers;
	}
	
	public void setSubscribers(Set<Profile> subscribers) {
		this.subscribers = subscribers;
	}
	
	@Transactional(readOnly = true)
	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getAge() {
		return age;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCountry() {
		return country;
	}
	 
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
}
