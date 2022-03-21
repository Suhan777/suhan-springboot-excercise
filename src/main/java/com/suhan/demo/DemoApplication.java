package com.suhan.demo;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(DemoApplication.class.getName());

		logger.info("Starting spring boot app");
		SpringApplication.run(DemoApplication.class, args);


	}

}
