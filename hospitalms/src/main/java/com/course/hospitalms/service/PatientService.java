package com.course.hospitalms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.hospitalms.model.Patient;
import com.course.hospitalms.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository repository;

	public void save(Patient patient) {
		
		repository.save(patient);
		
	}
}
