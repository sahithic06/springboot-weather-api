package com.spring.restapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.spring.restapi.models.WeatherUrl;

/**
 * @author sahithi
 *Sep 6, 2018
 * 
 */

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan
public class WeatherConfigurations {
	
	@Value("${weather.url}")
	private String url;
	
	@Value("${weather.apikey}")
	private String apikey;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {

		PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
		c.setIgnoreUnresolvablePlaceholders(true);
		return c;
	}
	
	@Bean
	public WeatherUrl weatherUrl() {
		
		WeatherUrl weatherUrl = new WeatherUrl();
		weatherUrl.setUrl(url);
		weatherUrl.setApiKey(apikey);
		return weatherUrl;
	}
}
