package com.spring.restapi.models;

/**
 * @author sahithi
 *Sep 5, 2018
 * 
 */

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productdb")
public class Product implements Serializable {

	private static final long serialVersionUID = 5604944562275121069L;

	@Id
	private String id;
	private String product;
	private String productType;
	private String description;

	public Product(  String product,String productType, String description) {
		
		this.product = product;
		this.description = description;
		this.productType = productType;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
