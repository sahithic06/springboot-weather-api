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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.restapi.models.Product;
import com.spring.restapi.services.ProductService;

import org.springframework.ui.Model;


@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(method=RequestMethod.GET, value="/")
	public String indexPage() {
		
		 return "redirect:" + "/product";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/product")
	public String product(Model model) {
	
        model.addAttribute("mongoData", productService.getAllProducts());
		return "mongoList";
    }
	
	//CRUD operations
	@RequestMapping(method=RequestMethod.GET, value="api/products")
	@ResponseBody
	public Iterable<Product> getAllProducts() {
   		return productService.getAllProducts();
    }
	
	@RequestMapping(method=RequestMethod.GET, value="api/product/{id}")
	public ResponseEntity<Optional<Product>> getProductById(@PathVariable(value="id") String id) {
		Optional<Product> prod = productService.findProductById(id);
		if(prod == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(prod);
	 }
	
	@RequestMapping(method=RequestMethod.POST, value="api/product")
    @ResponseBody
    public ResponseEntity<String> saveProducts(@RequestBody Product product) {
		productService.saveProduct(product);
        return ResponseEntity.ok().body(new String("Resource successFully created!!!"));
    }
	
	@RequestMapping(method=RequestMethod.DELETE, value="api/product/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable(value="id") String id) {
		productService.deleteProductById(id);   		
	    return ResponseEntity.ok().body(new String("Deleted successFully"));
	    
	}
		
}
