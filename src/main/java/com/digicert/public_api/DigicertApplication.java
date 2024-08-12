package com.digicert.public_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class DigicertApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigicertApplication.class, args);
	}

}
