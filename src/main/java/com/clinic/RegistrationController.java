package com.clinic;

import com.clinic.forms.RegistrationForm;
import com.clinic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView indexPage(Model model) {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("/register");
        model.addAttribute("user", new RegistrationForm());

        return mav;
    }

    @RequestMapping(value= "/register", method = RequestMethod.POST)
    public String addDoctor(@Valid @ModelAttribute("user") RegistrationForm user,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        this.userService.addUser(user);
        redirectAttributes.addFlashAttribute("message", "Wellcome!");

        return "redirect:/";
    }
}
