package com.spring.demospringbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemospringbootappApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemospringbootappApplication.class, args);
		
		Animal animal = context.getBean(Animal.class);
		animal.show();
	}

}
