package com.course.hospitalms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.hospitalms.repository.ChiefRepository;
import com.course.hospitalms.repository.DoctorRepository;

@Service
public class ChiefService {

	@Autowired
	private ChiefRepository repository;
}
