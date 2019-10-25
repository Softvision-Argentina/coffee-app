package com.rest.maxitest.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= "com.rest.maxitest.*")
@EnableJpaRepositories(basePackages= "com.rest.maxitest.*", entityManagerFactoryRef="entityManagerFactory")
@EntityScan(basePackages= "com.rest.maxitest.model")
@EnableAutoConfiguration 
public class AppConfig {
	
}
