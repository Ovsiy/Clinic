package com.clinic.controllers;

import com.clinic.exceptions.DublicateEmailException;
import com.clinic.model.Patient;
import com.clinic.service.DoctorService;
import com.clinic.service.PatientService;
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
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public ModelAndView listPatients() {

        ModelAndView mav = new ModelAndView("patient/listPatients");
        mav.addObject("listPatients", this.patientService.listPatients());

        return mav;
    }

    @RequestMapping(value = "/patient/add", method = RequestMethod.GET)
    public ModelAndView addPatient(Model model) {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("/patient/addPatient");

        model.addAttribute("patient", new Patient());
        model.addAttribute("doctors", this.doctorService.listDoctors());

        return mav;
    }

    @RequestMapping(value= "/patient/add", method = RequestMethod.POST)
    public String addPatient(@Valid @ModelAttribute("patient") Patient patient,
                            BindingResult bindingResult, final RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()) {
            return "patient/addPatient";
        }

        if(patient.getId() == 0){
            try {
                this.patientService.addPatient(patient);
            } catch (DublicateEmailException e) {
                bindingResult.rejectValue("profile.email", "", e.getMessage());
                return "patient/addPatient";
            }

            redirectAttributes.addFlashAttribute("message", "The patient has been successfully created");
        }else{
            this.patientService.updatePatient(patient);
            redirectAttributes.addFlashAttribute("message", "The patient has been successfully updated");
        }

        return "redirect:/patients";
    }

    @RequestMapping(value = "/patient/{id}/edit", method = RequestMethod.GET)
    public ModelAndView editPatient(Model model, @PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView("patient/addPatient");

        Patient patient = this.patientService.getPatientById(id);

        model.addAttribute("patient", patient);
        model.addAttribute("doctors", this.doctorService.listDoctors());

        return mav;
    }

    @RequestMapping(value = "/patient/{id}/remove")
    public String removePatient(@PathVariable("id") int id, RedirectAttributes redirectAttributes){
        this.patientService.removePatient(id);
        redirectAttributes.addFlashAttribute("message", "The patient has been successfully deleted");

        return "redirect:/patient/listPatients";
    }
}
