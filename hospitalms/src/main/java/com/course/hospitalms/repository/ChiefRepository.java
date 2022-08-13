package com.course.hospitalms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.hospitalms.model.Chief;
import com.course.hospitalms.model.Doctor;
import com.course.hospitalms.model.Tc;

@Repository
public interface ChiefRepository extends JpaRepository<Chief, Long>{
	Chief findByTc(Tc tc);
}
