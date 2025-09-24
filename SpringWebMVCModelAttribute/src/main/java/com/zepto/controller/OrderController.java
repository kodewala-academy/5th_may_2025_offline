package com.zepto.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zepto.entity.UserDetails;
import com.zepto.order.entity.OrderDetails;

@Controller
@RequestMapping("/orders")
public class OrderController {

	@PostMapping("/place")
	public String placeOrder(@RequestParam("userId") String userId, @RequestParam("productName") String productName,
			@RequestParam("amount") Double amount, Model model) {

		org.hibernate.cfg.Configuration config = new org.hibernate.cfg.Configuration();
		config.configure("/com/zepto/controller/hibernate/config/hibernate.cfg.xml");

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();

		UserDetails user = session.get(UserDetails.class, userId);

		if (user != null && "ACTIVE".equalsIgnoreCase(user.getStatus())) {

			OrderDetails order = new OrderDetails();
			order.setProductName(productName);
			order.setAmount(amount);

			user.setOrder(order);

			session.save(order);

			txn.commit();

			model.addAttribute("message", " Order placed successfully for user: " + user.getFirstName());
			model.addAttribute("order", order);
		} else {
			model.addAttribute("message", " Invalid user or inactive account.");
			txn.rollback();
		}

		session.close();
		return "orderResult"; // /WEB-INF/views/orderResult.jsp
	}


	@GetMapping("/view")
	public String viewOrder(@RequestParam("userId") String userId, Model model) {
		org.hibernate.cfg.Configuration config = new org.hibernate.cfg.Configuration();
		config.configure("/com/zepto/controller/hibernate/config/hibernate.cfg.xml");

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();

		UserDetails user = session.get(UserDetails.class, userId);

		if (user != null && user.getOrder() != null) {
			model.addAttribute("user", user);
			model.addAttribute("order", user.getOrder());
		} else {
			model.addAttribute("message", "No order found for this user.");
		}

		session.close();
		return "orderDetails"; // /WEB-INF/views/orderDetails.jsp
	}
}
