package com.test.Servlet;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String welcome(Model model) {
		Date today = new Date();
		model.addAttribute("today",today);
		return "welcome";
	}
	
	/*
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Model model) {
		Date today = new Date();
		model.addAttribute("today",today);
		return "welcome";
	}
	*/
	
	/*
	@GetMapping(value = "/welcome")
	public String welcome(Model model) {
		Date today = new Date();
		model.addAttribute("today",today);
		return "welcome";
	} 
	*/
}
