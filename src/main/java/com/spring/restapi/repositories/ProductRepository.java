package com.spring.restapi.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author sahithi
 *Sep 5, 2018
 * 
 */

import com.spring.restapi.models.Product;


public interface ProductRepository extends MongoRepository<Product, String> {
	public Optional<Product> findById(String id);
}
