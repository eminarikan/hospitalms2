package com.course.hospitalms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.course.hospitalms.model.Chief;
import com.course.hospitalms.model.Doctor;
import com.course.hospitalms.model.MyUserDetails;
import com.course.hospitalms.model.Patient;
import com.course.hospitalms.model.User;
import com.course.hospitalms.repository.ChiefRepository;
import com.course.hospitalms.repository.DoctorRepository;
import com.course.hospitalms.repository.PatientRepository;
import com.course.hospitalms.repository.TcRespository;

public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private ChiefRepository cr;
	@Autowired
	private DoctorRepository dr;
	@Autowired
	private PatientRepository pr;
	
	@Autowired
	private TcRespository tr;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Long tc = Long.valueOf(username);
		
		Doctor d = dr.findByTc(tr.findByTc(tc));
		Chief c = cr.findByTc(tr.findByTc(tc));
		Patient p = pr.findByTc(tr.findByTc(tc));
		
		User u = null;
		
		if(d != null) u = d;
		if(c != null) u = c;
		if(p != null) u = p;
		
		return new MyUserDetails(u);
	}

}
