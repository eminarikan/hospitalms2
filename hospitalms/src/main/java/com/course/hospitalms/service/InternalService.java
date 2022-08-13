package com.course.hospitalms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.hospitalms.model.Internal;
import com.course.hospitalms.repository.InternalRespository;

@Service
public class InternalService {

	@Autowired
	private InternalRespository repository;
	
	public void save(Internal internal) {
		repository.save(internal);
	}
	
	public List<Internal> getAllInternalsForDoctor(Long doctorTc){
		return repository.findAllByDoctorTc(doctorTc);
	}
}
