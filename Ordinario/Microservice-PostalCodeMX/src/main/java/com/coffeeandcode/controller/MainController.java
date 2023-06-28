	package com.coffeeandcode.controller;

	import com.coffeeandcode.model.CologneModel;
	import com.coffeeandcode.service.InterCologneService;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import java.util.List;

	@RestController
	@RequestMapping("/api")
	public class MainController {
		private final InterCologneService interCologneService;

		public MainController(InterCologneService interCologneService) {
			this.interCologneService = interCologneService;
		}

		@GetMapping("/search/{postalCode}")
		public ResponseEntity<?> searchByPostalCode(@PathVariable int postalCode) {
			List<CologneModel> colognes = interCologneService.findByPostalCode(postalCode);
			if (!colognes.isEmpty()) {
				return ResponseEntity.ok(colognes);
			} else {
				String errorMessage = "Element not found";
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
			}
		}
	}
