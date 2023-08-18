package com.springrest.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.springrest")
public class SpringBeansConfig 
{
	public DriverManagerDataSource dataSource()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/employee-dept-rest");
		ds.setUsername("root");
		ds.setPassword("root");
		
		return ds;	
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory()
	{
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.springrest.entity");
		sessionFactory.setHibernateProperties(readHibernateProps());
		return sessionFactory;
	}

	public Properties readHibernateProps() 
	{
		Properties prop = new Properties();
		
		prop.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
		prop.put("hibernate.show_sql","true");
		prop.put("hibernate.format_sql","true");
		prop.put("hibernate.hbm2ddl.auto","create");
		
		return prop;
	}
}
