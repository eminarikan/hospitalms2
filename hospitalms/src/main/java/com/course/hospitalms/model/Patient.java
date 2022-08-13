package com.course.hospitalms.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.course.hospitalms.constant.Constant;

@Entity
@Table(name = "patients")
public class Patient extends User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "patient")
	private List<Appointment> appointments;
	
	public Patient() {
		setRole();
	}
	
	public void setRole() {
		super.setRole(this.getRole());
	}
	
	@Override
	public String getRole() {
		return Constant.ROLE_PATIENT;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	
	
}
