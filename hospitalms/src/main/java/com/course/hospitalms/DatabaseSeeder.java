package com.course.hospitalms;

import org.apache.tomcat.util.net.jsse.PEMFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.course.hospitalms.model.Chief;
import com.course.hospitalms.model.Doctor;
import com.course.hospitalms.model.Tc;
import com.course.hospitalms.repository.ChiefRepository;
import com.course.hospitalms.repository.DoctorRepository;

@Component
public class DatabaseSeeder {
	
	@Autowired
	private ChiefRepository chiefRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PasswordEncoder pe;
	
	@EventListener
	public void seed(ContextRefreshedEvent event) {
		seedTables();
	}

	private void seedTables() {
		Chief c = new Chief();
		c.setName("Baş");
		c.setSurname("Hekim");
		c.setTc(new Tc(1000L));
		c.setPassword(pe.encode("123"));
		
		Doctor d = new Doctor();
		d.setName("Doctor");
		d.setSurname("Civanım");
		d.setTc(new Tc(1001L));
		d.setPassword(pe.encode("123"));
		
		chiefRepository.save(c);
		doctorRepository.save(d);
	}
	
}
