package com.course.hospitalms.controller.patient;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.course.hospitalms.model.Clinic;
import com.course.hospitalms.model.Doctor;
import com.course.hospitalms.model.Patient;
import com.course.hospitalms.model.Tc;
import com.course.hospitalms.model.Weather;
import com.course.hospitalms.service.PatientService;

@Controller
@RequestMapping("/patient/register")
public class RegisterController {

	@Autowired
	private Weather today;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	@GetMapping(path = {"/", ""})
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageName", "patientRegister");
		mav.addObject("todayWeather", today);
		mav.addObject("patient", new Patient());
		mav.setViewName("app");
		return mav;
	}
	
	@PostMapping(path = {"/", ""})
	  public ModelAndView register(
	      @ModelAttribute("patient") Patient patient,
	      @RequestParam("tc") Long tc,
	      HttpServletRequest request) {
	    
	    Tc tcObj = new Tc(tc);
	    patient.setTc(tcObj);
	    patient.setPassword(encoder.encode(patient.getPassword()));
	    patientService.save(patient);
	    
	    
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("pageName", "patientIndex");
	    mav.addObject("todayWeather", today);
	    mav.setViewName("app");
	    return mav;
	  }
	
	
}
