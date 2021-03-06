package com.clinic.controllers;

import com.clinic.exceptions.DublicateEmailException;
import com.clinic.model.Doctor;
import com.clinic.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @RequestMapping(value = "/doctors", method = RequestMethod.GET)
    public ModelAndView listDoctors() {

        ModelAndView mav = new ModelAndView("doctor/listDoctors");
        mav.addObject("listDoctors", this.doctorService.listDoctors());

        return mav;
    }

    @RequestMapping(value = "/doctor/{id}/show", method = RequestMethod.GET)
    public ModelAndView viewDoctor(@PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView("doctor/showDoctor");

        mav.addObject("doctor", this.doctorService.getDoctorById(id));

        return mav;
    }

    @RequestMapping(value = "/doctor/add", method = RequestMethod.GET)
    public ModelAndView addDoctor(Model model) {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("doctor/addDoctor");

        model.addAttribute("doctor", new Doctor());

        return mav;
    }

    @RequestMapping(value= "/doctor/add", method = RequestMethod.POST)
    public String addDoctor(@Valid @ModelAttribute("doctor") Doctor doctor,
                            BindingResult bindingResult, final RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()) {
            return "doctor/addDoctor";
        }

        if(doctor.getId() == 0){
            try {
                this.doctorService.addDoctor(doctor);
            } catch (DublicateEmailException e) {
                bindingResult.rejectValue("profile.email", "", e.getMessage());
                return "doctor/addDoctor";
            }

            redirectAttributes.addFlashAttribute("message", "The doctor has been successfully created");
        }else{
            this.doctorService.updateDoctor(doctor);
            redirectAttributes.addFlashAttribute("message", "The doctor has been successfully updated");
        }

        return "redirect:/doctors";
    }

    @RequestMapping(value = "/doctor/{id}/edit", method = RequestMethod.GET)
    public ModelAndView editDoctor(Model model, @PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView("doctor/addDoctor");
        model.addAttribute("doctor", this.doctorService.getDoctorById(id));

        return mav;
    }

    @RequestMapping(value = "/doctor/{id}/remove")
    public String removeDoctor(@PathVariable("id") int id, RedirectAttributes redirectAttributes){
        this.doctorService.removeDoctor(id);
        redirectAttributes.addFlashAttribute("message", "The doctor has been successfully deleted");

        return "redirect:/doctors";
    }
}
