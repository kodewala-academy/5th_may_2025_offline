package com.zepto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendActivationEmail(String to, String userId) {
		String subject = "Zepto Account Activation";
		String activationLink = "http://localhost:8080/SpringWebMVCModelAttribute/activate?userId=" + userId;

		String text = "Hi,\n\n" + "Thanks for registering with Zepto!\n"
				+ "Click the link below to activate your account:\n" + activationLink + "\n\n" + "Regards,\nZepto Team";

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);

		mailSender.send(message);
	}
}
