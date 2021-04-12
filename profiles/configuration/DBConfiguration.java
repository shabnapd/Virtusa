package com.virtusa.demo.profiles.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DBConfiguration {
	private String url;
	private String driverClassName;
	private String username;
	private String password;
		
	
	@Profile("dev")
	@Bean
	public String devdbConn() {
		return "DEV";
		
	}
	
	@Profile("test")
	@Bean
	public String testdbConn() {
		return "TEST";
		
	}
}
