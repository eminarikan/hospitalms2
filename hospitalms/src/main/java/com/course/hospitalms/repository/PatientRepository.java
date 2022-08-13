package com.course.hospitalms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.hospitalms.model.Chief;
import com.course.hospitalms.model.Doctor;
import com.course.hospitalms.model.Patient;
import com.course.hospitalms.model.Tc;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	Patient findByTc(Tc tc);
}
