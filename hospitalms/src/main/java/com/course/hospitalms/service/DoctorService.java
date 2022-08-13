package com.course.hospitalms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.hospitalms.model.Doctor;
import com.course.hospitalms.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository repository;

	public List<Doctor> findAll() {
		return repository.findAll();
	}

	public void save(Doctor doctor) {
		repository.save(doctor);
	}
	
	public Doctor findById(Long id) {
		return repository.findById(id).get();
	}

	public void delete(Long id) {
		repository.delete(repository.findById(id).get());
	}
	
}
