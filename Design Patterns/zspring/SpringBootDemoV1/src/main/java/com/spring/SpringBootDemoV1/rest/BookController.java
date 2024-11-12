package com.spring.SpringBootDemoV1.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@GetMapping("/")
	public String landingPage() {
		return "Landing Page";
	}
	
}
