package com.spring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.spring.jpademo.Modal.Animal;

@Component
public interface AnimalRepo extends CrudRepository<Animal, Integer> {
	
}
 