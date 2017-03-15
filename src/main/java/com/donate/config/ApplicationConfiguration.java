package com.donate.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.donate.*"})
@EnableJpaRepositories("com.donate.repository")
@EntityScan("com.donate.model")
public class ApplicationConfiguration {

	 public static void main(String[] args) {
	        SpringApplication.run(ApplicationConfiguration.class, args);
	    }
}
