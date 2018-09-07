package com.spring.restapi.models;

/**
 * @author sahithi
 *Sep 6, 2018
 * 
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather implements Serializable {

	private static final long serialVersionUID = 7406210628182440902L;
	
	private String weatherDescription;
	private double lon;
	private String name;
	private double lat;
	
	@Bean
	public Weather weather() {
		return new Weather();
	}
	
	public Weather() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Weather(Weather weather) {
		// TODO Auto-generated constructor stub
	}

	public double getLat() {
		return lat;
	}

	@JsonProperty("lat")
	public void setLat(double lat) {
		this.lat = lat;
	}

	
	public String getName() {
		return name;
	}
	
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	public String getWeatherDescription() {
		return weatherDescription;
	}

	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}

	@JsonProperty("weather")
	public void setWeather(List<Map<String, Object>> weatherEntries) {
		Map<String, Object> weather = weatherEntries.get(0);
		setWeatherDescription((String) weather.get("description"));
	}

	@JsonProperty("lon")
	public double getLon() {
		return lon;
	}

	@JsonProperty("lon")
	public void setLon(double lon) {
		this.lon = lon;
	}
	
	@JsonProperty("coord")
	public void setCoord(Map<String, Object> coord) {
		setLon((double) coord.get("lon"));
		setLat((double) coord.get("lat"));
		
	}
	
	
	
}
