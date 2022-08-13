package com.course.hospitalms.controller;

import com.course.hospitalms.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @Autowired
  private Weather today;

  @GetMapping("/")
  public String home(ModelMap model) {
    model.addAttribute("todayWeather", today);
    model.addAttribute("pageName", "home");
    return "app";
  }
}
