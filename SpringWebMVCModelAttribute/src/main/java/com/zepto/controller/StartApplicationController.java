package com.zepto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartApplicationController {

	@RequestMapping("/showPage")
	public String startApplication() {
		System.out.println("StartApplicationController.startApplication().........");
		return "showUserRegPage";
	}
}
