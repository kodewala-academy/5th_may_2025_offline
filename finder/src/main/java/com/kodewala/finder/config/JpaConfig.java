package com.kodewala.finder.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class JpaConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/zepto_5th_may");
		ds.setUsername("root");
		ds.setPassword("Test@12345");
		return ds;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		emf.setPackagesToScan("com.kodewala.finder.entity");
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		Properties props = new Properties();
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		emf.setJpaProperties(props);

		return emf;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
