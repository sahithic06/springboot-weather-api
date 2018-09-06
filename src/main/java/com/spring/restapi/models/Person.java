package com.spring.restapi.models;

/**
 * @author sahithi
 *Sep 5, 2018
 * 
 */

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "persondb")
public class Person implements Serializable {

	private static final long serialVersionUID = 5604944562275121069L;

	@Id 
	private String id;
	private String firstName;
	private String lastName;

	public Person(  String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
