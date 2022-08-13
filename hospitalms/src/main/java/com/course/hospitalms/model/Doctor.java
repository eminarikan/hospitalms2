package com.course.hospitalms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.course.hospitalms.constant.Constant;

@Entity
@Table(name = "doctors")
public class Doctor extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Clinic clinic;
	
	@OneToMany(mappedBy = "doctor")
	private List<Internal> internals;

	@Transient
	private Long clinicId;
	
	public List<Internal> getInternals() {
		return internals;
	}
	public void setInternals(List<Internal> internals) {
		this.internals = internals;
	}
	
	
	public Doctor() {
		setRole();
	}
	
	
	public Long getClinicId() {
		return clinicId;
	}
	
	public void setClinicId(Long clinicId) {
		this.clinicId = clinicId;
	}
	
	public void setRole() {
		super.setRole(this.getRole());
	}
	
	@Override
	public String getRole() {
		return Constant.ROLE_DOCTOR;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	
	
}
