package com.course.hospitalms.controller.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.course.hospitalms.model.Internal;
import com.course.hospitalms.model.MyUserDetails;
import com.course.hospitalms.model.Weather;
import com.course.hospitalms.service.DoctorService;
import com.course.hospitalms.service.InternalService;

@Controller
@RequestMapping(path = "/doctor/internals")
public class InternalController {

	@Autowired
	private Weather today;

	@Autowired
	private InternalService internalService;
	
	@Autowired
	private DoctorService doctorService;
	
	

	@GetMapping(path = { "", "/" })
	public ModelAndView index() {
		
		MyUserDetails d = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Long doctorTc = Long.valueOf(d.getUsername());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageName", "doctorInternalIndex");
		mav.addObject("todayWeather", today);
		mav.addObject("internals", internalService.getAllInternalsForDoctor(doctorTc));
		mav.setViewName("app");
		return mav;
	}

	@GetMapping(path = { "/create" })
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageName", "doctorInternalCreate");
		mav.addObject("todayWeather", today);
		mav.addObject("internal", new Internal());
		mav.setViewName("app");
		return mav;
	}

	@PostMapping(path = "/create")
	public ModelAndView save(@ModelAttribute("internal") Internal internal) {

		
		MyUserDetails d = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Long doctorTc = Long.valueOf(d.getUsername());
		
		internal.setDoctor(doctorService.findById(doctorTc));
		
		internalService.save(internal);

		ModelAndView mav = new ModelAndView();
		mav.addObject("pageName", "doctorInternalIndex");
		mav.addObject("todayWeather", today);
		mav.setViewName("app");
		return mav;
	}
}
