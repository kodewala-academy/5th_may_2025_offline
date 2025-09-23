package com.zepto.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.zepto.controller.utils.Utils;
import com.zepto.entity.UserDetails;

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

	@PostMapping("/registerORM")
	public String doRegistrationORM(@ModelAttribute UserInfo info, Model model) {

		System.out.println(" First Name :" + info.getFirstName());
		System.out.println(" Last Name :" + info.getLastName());

		String uniqueId = java.util.UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5);
		String firstName = info.getFirstName();
		String lastName = info.getLastName();
		String status = Utils.PENDING;

		org.hibernate.cfg.Configuration config = new org.hibernate.cfg.Configuration();

		config.configure("/com/zepto/controller/hibernate/config/hibernate.cfg.xml");

		SessionFactory sessionFactory = config.buildSessionFactory();

		Session session = sessionFactory.openSession();

		org.hibernate.Transaction txn = session.beginTransaction();

		UserDetails details = new UserDetails();

		details.setFirstName(firstName);
		details.setLastName(lastName);
		details.setUserName(uniqueId);
		details.setStatus(status);

		session.save(details);// saving this object to the table.

		txn.commit();

		System.out.println(" User has been registered successfully, Generated user id is : " + uniqueId
				+ ". Use the activation link sent over you email.");

		info.setUserId(uniqueId);
		model.addAttribute("user", info);
		return "registrationConfirmation"; // /WEB-INF/views/registrationConfirmation.jsp

	}

}
