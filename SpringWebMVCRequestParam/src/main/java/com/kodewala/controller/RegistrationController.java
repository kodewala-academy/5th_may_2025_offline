package com.kodewala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

	@RequestMapping("/showRegPage")
	public ModelAndView showRegPage() {
		System.out.println("RegistrationController.showRegPage()");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("registration");
		return mv;
	}

	@PostMapping("/register")
	@ResponseBody
	public String processRegistration(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
		System.out.println("RegistrationController.processRegistration()");
		System.out.println(" First Name " + firstName);
		System.out.println(" Last Name " + lastName);
		return "You registration has been done and your submitted details are : " + firstName + " and " + lastName;
	}
}
