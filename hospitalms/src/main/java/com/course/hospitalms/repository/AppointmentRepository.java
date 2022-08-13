package com.course.hospitalms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.hospitalms.model.Appointment;
import com.course.hospitalms.model.Chief;
import com.course.hospitalms.model.Doctor;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

}
