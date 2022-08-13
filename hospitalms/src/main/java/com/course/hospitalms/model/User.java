package com.course.hospitalms.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class User {
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Tc tc;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String surname;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String role;
	
	public Tc getTc() {
		return tc;
	}
	public void setTc(Tc tc) {
		this.tc = tc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public abstract String getRole();
	
	public void setRole(String role) {
		this.role = role;
	}
}
