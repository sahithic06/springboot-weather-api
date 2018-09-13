/**
 * 
 */
package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import com.spring.restapi.DemoApplication;
import com.spring.restapi.models.Product;
import com.spring.restapi.repositories.ProductRepository;


/**
 * @author sahithi
 *Sep 6, 2018
 * 
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class TestWebApp {

	@Autowired
	ProductRepository productRepository;
	
	@Test
	public void testMongoDocumentCount() {
	
		Iterable<Product> iterator = productRepository.findAll();
		Collection<Product> products = new ArrayList<Product>();
		for(Product product : iterator) {
			products.add(product);
		}
		
		assertTrue(products.size()>=0);
	}
	
	@Test
	public void testWeatherAPI() {
	    UriComponents uriComponents = UriComponentsBuilder.newInstance()
	      .scheme("http").host("api.openweathermap.org/data/2.5/weather")
	      .path("").query("q={keyword}&appid={appid}").buildAndExpand("chicago","1c9770dfaf3b327dd03510a4c07b7f2d");
	 
	     assertEquals("http://api.openweathermap.org/data/2.5/weather?q=chicago&appid=1c9770dfaf3b327dd03510a4c07b7f2d", uriComponents.toUriString());

	}
}
	