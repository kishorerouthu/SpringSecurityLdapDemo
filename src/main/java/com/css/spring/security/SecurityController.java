package com.css.spring.security;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Kishore Routhu on 12/3/18 3:32 PM.
 */
@Controller
public class SecurityController {

    @RequestMapping(value ="/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = {"/home", "/"}, method = RequestMethod.GET)
    public ModelAndView home(ModelAndView modelAndView, Principal principal) {
        modelAndView.setViewName("home");
        String username = principal.getName();
        modelAndView.addObject("username", username);
        System.out.printf("Successfully logged in by %s", username);
        return modelAndView;
    }
}
