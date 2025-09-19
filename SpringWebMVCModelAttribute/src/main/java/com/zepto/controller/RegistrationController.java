package com.zepto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

	@PostMapping("/register")
	public String doRegistration(@ModelAttribute UserInfo info, Model model) {

		System.out.println(" First Name :" + info.getFirstName());
		System.out.println(" Last Name :" + info.getLastName());
		// 1. Called service layer and from service layer, we have called repo layer and
		// inserted data to database
		String uniqueId = java.util.UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5);
		System.out.println(" User has been registered successfully, Generated user id is : " + uniqueId);
		info.setUserId(uniqueId);
		model.addAttribute("user", info);
		return "registrationConfirmation"; // /WEB-INF/views/registrationConfirmation.jsp

	}
}
