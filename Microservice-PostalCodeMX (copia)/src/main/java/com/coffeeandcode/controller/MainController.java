package com.coffeeandcode.controller;

import com.coffeeandcode.model.PostalCodeModel;
import com.coffeeandcode.service.InterPostalCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {
	private final InterPostalCodeService interPostalCodeService;

	public MainController(InterPostalCodeService interPostalCodeService) {
		this.interPostalCodeService = interPostalCodeService;
	}

	@GetMapping("/search/{postalcode}")
	public ResponseEntity<List<PostalCodeModel>> searchByPostalCode(@PathVariable("postalcode") int postalCode) {
		List<PostalCodeModel> postalCodes = interPostalCodeService.findPostalCodesByPostalCode(postalCode);
		if (postalCodes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(postalCodes);
	}
}
