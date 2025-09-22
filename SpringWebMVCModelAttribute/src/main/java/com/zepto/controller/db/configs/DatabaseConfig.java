package com.zepto.controller.db.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {

	// Data Source object / bean

	@Bean
	public DriverManagerDataSource createDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/zepto_5th_may");
		dataSource.setUsername("root");
		dataSource.setPassword("Test@12345");
		return dataSource;
	}

	// JDBC template
	@Bean
	public JdbcTemplate createJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(createDataSource());
		return jdbcTemplate;
	}
}
