package com.spring.restapi.controllers;

import java.util.Optional;

/**
 * @author sahithi
 *Sep 5, 2018
 * 
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.spring.restapi.models.Product;
import com.spring.restapi.repositories.ProductRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;


@Controller
public class ProductMVCController {

	@Autowired
	ProductRepository productRepository;

	
	@RequestMapping(method=RequestMethod.GET, value="/")
	public String indexPage() {
		
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/product")
	public String product(Model model) {
	
        model.addAttribute("mongoData", productRepository.findAll());
		return "mongoList";
    }
	
	@RequestMapping(method=RequestMethod.GET, value="/productJson")
    @ResponseBody
    public Iterable<Product> productJson() {
   		return productRepository.findAll();
    }
	
	@RequestMapping(method=RequestMethod.GET, value="/productJson/{id}")
	public ResponseEntity<Optional<Product>> getProductById(@PathVariable(value="id") String id) {
		Optional<Product> prod = productRepository.findById(id);
		if(prod == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(prod);
	 }
	
	@RequestMapping(method=RequestMethod.POST, value="/productJson")
    @ResponseBody
    public ResponseEntity<String> save(@RequestBody Product product) {
		productRepository.save(product);
        return ResponseEntity.ok().body(new String("Resource successFully created!!!"));
    }
	
	@RequestMapping(method=RequestMethod.DELETE, value="/productJson/{id}")
    public ResponseEntity<String> delete(@PathVariable(value="id") String id) {
		productRepository.deleteById(id);   		
	    return ResponseEntity.ok().body(new String("Deleted successFully"));
	    
	}
		
}
