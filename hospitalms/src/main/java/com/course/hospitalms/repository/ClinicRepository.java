package com.course.hospitalms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.hospitalms.model.Clinic;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Long>{

}
