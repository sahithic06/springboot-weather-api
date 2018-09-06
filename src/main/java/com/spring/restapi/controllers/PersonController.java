package com.spring.restapi.controllers;

/**
 * @author sahithi
 *Sep 5, 2018
 * 
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.spring.restapi.models.Person;
import com.spring.restapi.repositories.PersonRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;


@Controller
public class PersonController {

	@Autowired
	PersonRepository personRepository;

	
	@RequestMapping(method=RequestMethod.GET, value="/")
	public String indexPage() {
		
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/persons")
	public String person(Model model) {
	
        model.addAttribute("mongoli", personRepository.findAll());
		return "mongoList";
    }

	
	@RequestMapping(method=RequestMethod.GET, value="/personslist")
    @ResponseBody
    public Iterable<Person> personlist() {
	
   		return personRepository.findAll();
    }
	
	
	@RequestMapping(method=RequestMethod.POST, value="/persons")
    @ResponseBody
    public String save(@RequestBody Person person) {
		personRepository.save(person);
        return person.getId();
    }
}
