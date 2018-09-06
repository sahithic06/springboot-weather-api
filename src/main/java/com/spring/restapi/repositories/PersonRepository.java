package com.spring.restapi.repositories;

/**
 * @author sahithi
 *Sep 5, 2018
 * 
 */

import org.springframework.data.repository.CrudRepository;
import com.spring.restapi.models.Person;


public interface PersonRepository extends CrudRepository<Person, String> {
	
}
