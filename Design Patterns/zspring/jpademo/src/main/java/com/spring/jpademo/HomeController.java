package com.spring.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dao.AnimalRepo;
import com.spring.jpademo.Modal.Animal;

@Controller
public class HomeController {
	@Autowired
	AnimalRepo repo;
	
	@GetMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addAnimal")
	public String addAnimal(Animal animal) {
		repo.save(animal);
		return "home.jsp";
	}
}
