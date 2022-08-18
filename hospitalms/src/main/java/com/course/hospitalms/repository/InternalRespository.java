package com.course.hospitalms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.hospitalms.model.Doctor;
import com.course.hospitalms.model.Internal;

@Repository
public interface InternalRespository extends JpaRepository<Internal, Long> {

	List<Internal> findAllByDoctor(Doctor doctor);

}
