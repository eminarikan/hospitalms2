package com.course.hospitalms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.course.hospitalms.model.Clinic;
import com.course.hospitalms.model.Weather;
import com.course.hospitalms.service.ClinicService;

@Controller
@RequestMapping("/clinics")
public class ClinicController {

	@Autowired
	private Weather today;
	
	@Autowired
	private ClinicService clinicService;
	
	@GetMapping(path = {"", "/"})
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("pageName", "clinicIndex");
		mav.addObject("todayWeather", today);
		mav.addObject("clinics", clinicService.findAll());
		mav.setViewName("app");
		
		return mav;
	}
	
	@GetMapping(path = {"/create"})
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("pageName", "clinicCreate");
		mav.addObject("todayWeather", today);
		mav.addObject("clinic", new Clinic());
		mav.setViewName("app");
		
		return mav;
	}
	
	@PostMapping(path = "/create")
	public ModelAndView save(@ModelAttribute("clinic") Clinic clinic) {
		
		clinicService.save(clinic);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("pageName", "clinicIndex");
		mav.addObject("todayWeather", today);
		mav.addObject("clinics", clinicService.findAll());
		mav.setViewName("app");
		return mav;
	}
	
	@GetMapping(path = "/{id}/show")
	public ModelAndView show(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageName", "clinicShow");
		mav.addObject("todayWeather", today);
		mav.addObject("clinic", clinicService.findById(id));
		mav.setViewName("app");
		return mav;
	}
	
	@GetMapping(path = "/{id}/delete")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		clinicService.delete(id);

		ModelAndView mav = new ModelAndView();
		mav.addObject("pageName", "clinicIndex");
		mav.addObject("todayWeather", today);
		mav.addObject("clinics", clinicService.findAll());
		mav.setViewName("app");
		return mav;
	}
	
	@GetMapping(path = "/{id}/edit")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageName", "clinicEdit");
		mav.addObject("todayWeather", today);
		mav.addObject("clinic", clinicService.findById(id));
		mav.setViewName("app");
		return mav;
	}
	
	@PostMapping(path = "/{id}/edit")
	public ModelAndView update(@ModelAttribute("clinic") Clinic clinic,
			@PathVariable("id") Long id) {
		clinic.setId(id);
		clinicService.save(clinic);
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageName", "clinicIndex");
		mav.addObject("todayWeather", today);
		mav.addObject("clinics", clinicService.findAll());
		mav.setViewName("app");
		return mav;
	}
	
}
