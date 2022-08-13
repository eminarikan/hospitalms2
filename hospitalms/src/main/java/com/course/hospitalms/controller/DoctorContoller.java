package com.course.hospitalms.controller;

import com.course.hospitalms.model.Clinic;
import com.course.hospitalms.model.Doctor;
import com.course.hospitalms.model.Tc;
import com.course.hospitalms.model.Weather;
import com.course.hospitalms.repository.TcRespository;
import com.course.hospitalms.service.ClinicService;
import com.course.hospitalms.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/doctors")
public class DoctorContoller {

  @Autowired
  private Weather today;

  @Autowired
  private DoctorService doctorService;

  @Autowired
  private ClinicService clinicService;

  @Autowired
  private TcRespository tcRespository;

  @GetMapping(path = { "", "/", "/index" })
  public ModelAndView index() {
    ModelAndView mav = new ModelAndView();
    mav.addObject("pageName", "doctorIndex");
    mav.addObject("todayWeather", today);
    mav.addObject("doctors", doctorService.findAll());
    mav.setViewName("app");
    return mav;
  }

  @GetMapping(path = { "/create" })
  public ModelAndView create() {
    ModelAndView mav = new ModelAndView();
    mav.addObject("pageName", "doctorCreate");
    mav.addObject("todayWeather", today);
    mav.addObject("doctor", new Doctor());
    mav.addObject("clinics", clinicService.findAll());
    mav.setViewName("app");
    return mav;
  }

  @PostMapping(path = "/create")
  public ModelAndView save(
      @ModelAttribute("doctor") Doctor doctor,
      @RequestParam(name = "clinicId", required = false) Long clinicId,
      @RequestParam("tc") Long tc) {
    if (clinicId != null) {
      Clinic c = clinicService.findById(clinicId);
      doctor.setClinic(c);
    }
    Tc tcObj = new Tc(tc);
    doctor.setTc(tcObj);
    doctorService.save(doctor);
    ModelAndView mav = new ModelAndView();
    mav.addObject("pageName", "doctorIndex");
    mav.addObject("todayWeather", today);
    mav.addObject("doctors", doctorService.findAll());
    mav.setViewName("app");
    return mav;
  }

  @GetMapping(path = "/{id}/show")
  public ModelAndView show(@PathVariable("id") Long id) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("pageName", "doctorShow");
    mav.addObject("todayWeather", today);
    mav.addObject("doctor", doctorService.findById(id));
    mav.setViewName("app");
    return mav;
  }

  @GetMapping(path = "/{id}/delete")
  public ModelAndView delete(@PathVariable("id") Long id) {
    doctorService.delete(id);

    ModelAndView mav = new ModelAndView();
    mav.addObject("pageName", "doctorIndex");
    mav.addObject("todayWeather", today);
    mav.addObject("doctors", doctorService.findAll());
    mav.setViewName("app");
    return mav;
  }

  @GetMapping(path = "/{id}/edit")
  public ModelAndView edit(@PathVariable("id") Long id) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("pageName", "doctorEdit");
    mav.addObject("todayWeather", today);
    mav.addObject("doctor", doctorService.findById(id));
    mav.addObject("clinics", clinicService.findAll());
    mav.setViewName("app");
    return mav;
  }

  @PostMapping(path = "/{id}/edit")
  public ModelAndView update(
      @ModelAttribute("doctor") Doctor doctor,
      @PathVariable("id") Long id,
      @RequestParam("tc") Long tc) {
    if (doctor.getClinicId() != null) {
      Clinic c = clinicService.findById(doctor.getClinicId());
      doctor.setClinic(c);
    }
    Tc tcObj = tcRespository.findByTc(tc);

    doctor.setId(id);
    doctor.setTc(tcObj);

    doctorService.save(doctor);
    ModelAndView mav = new ModelAndView();
    mav.addObject("pageName", "doctorIndex");
    mav.addObject("todayWeather", today);
    mav.addObject("doctors", doctorService.findAll());
    mav.setViewName("app");
    return mav;
  }
}
