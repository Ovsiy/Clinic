package com.clinic.controllers;

import com.clinic.pojos.OutputChatMessage;
import com.clinic.pojos.InputChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatController {
    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public ModelAndView chat()
    {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = user.getUsername();

        ModelAndView mav = new ModelAndView("chat/index");
        mav.addObject("email", email);

        return mav;
    }

    @MessageMapping("/hello")
    @SendTo("/topic/message")
    public OutputChatMessage greeting(InputChatMessage message) throws Exception
    {
        Thread.sleep(1000); // simulated delay
        return new OutputChatMessage(message.getMessage(), message.getUserEmail());
    }
}