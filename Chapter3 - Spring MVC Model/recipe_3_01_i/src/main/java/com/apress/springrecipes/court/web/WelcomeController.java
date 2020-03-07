package com.apress.springrecipes.court.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String welcome(Model model) {
        Date today = new Date();
        model.addAttribute("today", today);

        return "welcome";
    }
    
    //RquestMapping을 매소드 레벨에 붙이는 것도 가능.
    /*
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome2(Model model) {
    	return "";
    }
    */
    
    /*
    @GetMapping("/welcome")
    public String welcome3(Model model) {
    	return "";
    }
    */
    
}