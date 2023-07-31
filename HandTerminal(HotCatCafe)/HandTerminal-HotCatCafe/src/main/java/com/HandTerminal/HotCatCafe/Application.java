package com.HandTerminal.HotCatCafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.HandTerminal.HotCatCafe.exceptions.RestTemplateResponseErrorHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class Application {

	@Bean
	public RestTemplate restTemplate(ObjectMapper objectMapper) {
		return new RestTemplateBuilder()
			.errorHandler(new RestTemplateResponseErrorHandler(objectMapper))
			.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
