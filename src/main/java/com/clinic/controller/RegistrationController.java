package com.clinic.controller;

import com.clinic.event.RegistrationEventPublisher;
import com.clinic.forms.RegistrationForm;
import com.clinic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    @Qualifier("authenticationManager")
    protected AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private RegistrationEventPublisher publisher;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView indexPage(Model model) {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("/register");
        model.addAttribute("user", new RegistrationForm());

        return mav;
    }

    @RequestMapping(value= "/register", method = RequestMethod.POST)
    public String addDoctor(@Valid @ModelAttribute("user") RegistrationForm user,
                            BindingResult bindingResult, HttpServletRequest request, final RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        this.userService.addUser(user);

        this.publisher.publish();

        this.forceLoginUser(user, request);

        redirectAttributes.addFlashAttribute("message", "Welcome, " + user.getEmail());

        return "redirect:/";
    }

    private void forceLoginUser(RegistrationForm user, HttpServletRequest request) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword(), userDetails.getAuthorities());
        request.getSession();
        token.setDetails(new WebAuthenticationDetails(request));

        Authentication authenticatedUser = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);

        request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
    }
}
