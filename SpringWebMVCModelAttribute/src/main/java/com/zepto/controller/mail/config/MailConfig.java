package com.zepto.controller.mail.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

	@Bean
	public JavaMailSender mailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("sandbox.smtp.mailtrap.io");
	    mailSender.setPort(2525);
	    mailSender.setUsername("742a0ddceb1012");
	    mailSender.setPassword("6362f914a3fcdd");

	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.ssl.trust", "sandbox.smtp.mailtrap.io");

	    return mailSender;
	}

}
