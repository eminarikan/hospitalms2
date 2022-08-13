package com.course.hospitalms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.hospitalms.model.Appointment;
import com.course.hospitalms.repository.AppointmentRepository;
import com.course.hospitalms.repository.ChiefRepository;
import com.course.hospitalms.repository.DoctorRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository repository;

	public List<Appointment> getAppointmentsForDoctor(String tc) {
		// TODO Auto-generated method stub
		return null;
	}
}
