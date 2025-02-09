package com.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootJMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJMSApplication.class, args);
	}

}
