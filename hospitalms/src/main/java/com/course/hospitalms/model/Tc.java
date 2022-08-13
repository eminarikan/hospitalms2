package com.course.hospitalms.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="tcs")
public class Tc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private Long tc;
	
	public Tc() {}
	
	public Tc(Long tc) {
		this.tc = tc;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTc() {
		return tc;
	}
	
	public String getTcText() {
		return String.valueOf(tc);
	}
	public void setTc(Long tc) {
		this.tc = tc;
	}
}
