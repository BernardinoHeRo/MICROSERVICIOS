package com.coffeeandcode.client;

import com.coffeeandcode.model.location.CologneModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class PostalCodeMxClient {
	private final WebClient webClient;

	public PostalCodeMxClient(WebClient webClient) {
		this.webClient = webClient;
	}

	public Mono<List<CologneModel>> getCologneModelsByPostalCode(int postalCode) {
		return webClient.get()
				.uri("/api/search/{postalCode}", postalCode)
				.retrieve()
				.bodyToFlux(CologneModel.class)
				.collectList();
	}
}
