package com.kodewala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyFirstController {

	@RequestMapping("/welcome")
	public ModelAndView doWelcome() {
		System.out.println(" Welcome page will be displayed!!!!");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("response");
		return modelAndView; // response back to browser
	}

}
