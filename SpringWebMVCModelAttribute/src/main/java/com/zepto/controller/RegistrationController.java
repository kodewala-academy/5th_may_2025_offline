package com.zepto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.zepto.controller.utils.Utils;

@Controller
public class RegistrationController {

	@Autowired
	public JdbcTemplate jdbcTemplate;

	@PostMapping("/register")
	public String doRegistration(@ModelAttribute UserInfo info, Model model) {

		System.out.println(" First Name :" + info.getFirstName());
		System.out.println(" Last Name :" + info.getLastName());
		// 1. Called service layer and from service layer, we have called repo layer and
		// inserted data to database
		String uniqueId = java.util.UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5);
		String firstName = info.getFirstName();
		String lastName = info.getLastName();
		String status = Utils.PENDING;
		String query = "insert into userinfo values('" + firstName + "' , '" + lastName + "' , '" + uniqueId + "' ,'"
				+ status + "')";
		System.out.println(" query is ::::::::::::::" + query);

		jdbcTemplate.execute(query);

		System.out.println(" User has been registered successfully, Generated user id is : " + uniqueId
				+ ". Use the activation link sent over you email.");

		info.setUserId(uniqueId);
		model.addAttribute("user", info);
		return "registrationConfirmation"; // /WEB-INF/views/registrationConfirmation.jsp

	}
	
	
	
}
