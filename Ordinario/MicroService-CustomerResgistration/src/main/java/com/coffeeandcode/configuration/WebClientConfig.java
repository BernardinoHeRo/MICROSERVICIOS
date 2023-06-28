package com.coffeeandcode.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
	@Bean
	public WebClient webClient() {
		return WebClient.create("http://localhost:9091"); // Ajusta la URL base según la configuración de tu microservicio PostalCodeMx
	}
}
