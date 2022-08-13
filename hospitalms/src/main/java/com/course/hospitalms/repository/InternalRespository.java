package com.course.hospitalms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.course.hospitalms.model.Internal;

@Repository
public interface InternalRespository extends JpaRepository<Internal, Long> {

	@Query("SELECT * FROM Internal WHERE doctor_id = :doctorTc")
	List<Internal> findAllByDoctorTc(@Param("doctorTc") Long doctorTc);

}
