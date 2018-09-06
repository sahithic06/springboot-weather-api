package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.restapi.controllers.PersonController;
import com.spring.restapi.models.Person;
import com.spring.restapi.repositories.PersonRepository;

@RunWith(SpringRunner.class)
@Configuration
public class DemoApplicationTests {
	
	@Autowired
	PersonRepository personRepository;

	//@Test
	public void testWeatherAPI() {
	    UriComponents uriComponents = UriComponentsBuilder.newInstance()
	      .scheme("http").host("api.openweathermap.org/data/2.5/weather")
	      .path("").query("q={keyword}&appid={appid}").buildAndExpand("chicago","1c9770dfaf3b327dd03510a4c07b7f2d");
	 
	     assertEquals("http://api.openweathermap.org/data/2.5/weather?q=chicago&appid=1c9770dfaf3b327dd03510a4c07b7f2d", uriComponents.toUriString());
	
	    // assertEquals(weather.getLon(), "-87.62");
	    // assertEquals(weather.getLat(), "41.88");
	}
	
	@Test
	public void testMongoDocuments() {
		
		Iterable<Person> iterator = personRepository.findAll();
		Collection<Person> cltn = new ArrayList<Person>();
		for(Person t : iterator) {
            cltn.add(t);
		}
		
		assertEquals(cltn.size(), 4);
	}
}
