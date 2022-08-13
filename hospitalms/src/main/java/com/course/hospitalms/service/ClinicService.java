package com.course.hospitalms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.hospitalms.model.Clinic;
import com.course.hospitalms.repository.ClinicRepository;

@Service
public class ClinicService {

	@Autowired
	private ClinicRepository repository;
	
	public void save(Clinic clinic) {
		repository.save(clinic);
	}
	
	public List<Clinic> findAll(){
		return repository.findAll();
	}
	
	public Clinic findById(Long id) {
		return repository.findById(id).get();
	}


	public void delete(Long id) {
		
		repository.delete(repository.findById(id).get());
		
	}
}
