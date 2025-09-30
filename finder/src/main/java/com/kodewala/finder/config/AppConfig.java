package com.kodewala.finder.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.kodewala.finder")
public class AppConfig {
	// Your DataSource and EntityManagerFactory beans here
}
