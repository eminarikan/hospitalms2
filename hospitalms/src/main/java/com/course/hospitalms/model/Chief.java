package com.course.hospitalms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.course.hospitalms.constant.Constant;

@Entity
@Table(name = "chiefs")
public class Chief extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Chief() {
		setRole();
	}

	@Override
	public String getRole() {
		return Constant.ROLE_CHIEF;
	}

	public void setRole() {
		super.setRole(this.getRole());
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
