package com.spring.restapi.models;

/**
 * @author sahithi
 *Sep 6, 2018
 * 
 */

public class FormCityAttribute {
	
	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public FormCityAttribute(String city) {
		super();
		this.city = city;
	}

	public FormCityAttribute() {
		super();
	}
}
