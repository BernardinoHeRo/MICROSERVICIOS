package com.coffeeandcode.controller;

import com.coffeeandcode.client.PostalCodeMxClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.coffeeandcode.model.location.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerRegistrationController {
	private final PostalCodeMxClient postalCodeMxClient;

	public CustomerRegistrationController(PostalCodeMxClient postalCodeMxClient) {
		this.postalCodeMxClient = postalCodeMxClient;
	}
	@GetMapping("/example/{postalCode}")
	public Mono<ResponseEntity<List<CologneModel>>> exampleEndpoint(@PathVariable int postalCode) {
		Mono<List<CologneModel>> colognes = postalCodeMxClient.getCologneModelsByPostalCode(postalCode);
		return colognes.map(ResponseEntity::ok);
	}
}
