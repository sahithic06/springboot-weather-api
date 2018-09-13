/**
 * 
 */
package com.spring.restapi.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.restapi.models.Product;
import com.spring.restapi.repositories.ProductRepository;


/**
 * @author sahithi
 *Sep 9, 2018
 * 
 */
@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public Iterable<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public  Optional<Product> findProductById(String id) {
		return productRepository.findById(id);
	}
	
	public void saveProduct(Product product) {
		productRepository.save(product);
	}
	
	public void deleteProductById(String id) {
		productRepository.deleteById(id);
	}

}

