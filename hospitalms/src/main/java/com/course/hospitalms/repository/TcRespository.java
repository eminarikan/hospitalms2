package com.course.hospitalms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.hospitalms.model.Tc;

@Repository
public interface TcRespository extends JpaRepository<Tc, Long> {

	Tc findByTc(Long tc);
}
