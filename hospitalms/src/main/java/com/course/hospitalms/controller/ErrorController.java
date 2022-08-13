package com.course.hospitalms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ErrorController {

	@GetMapping(path = "/error")
	public ModelAndView error() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageName", "error");
		mav.setViewName("app");
		return mav;
	}
}
