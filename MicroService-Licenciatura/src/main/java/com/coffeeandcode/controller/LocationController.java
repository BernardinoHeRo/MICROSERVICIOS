package com.coffeeandcode.controller;

import com.coffeeandcode.modell.LocationModell;
import com.coffeeandcode.service.InterfaceLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {
	private final InterfaceLocationService interfaceLocationService;

	@Autowired
	public LocationController(InterfaceLocationService interfaceLocationService) {
		this.interfaceLocationService = interfaceLocationService;
	}

	@GetMapping("/list")
	public ResponseEntity<?> getAllLocations() {
		List<LocationModell> locationModellList = interfaceLocationService.listAllLocations();
		if (locationModellList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La tabla está vacía");
		} else {
			return ResponseEntity.ok(locationModellList);

		}
	}

	@PostMapping("/add")
	public ResponseEntity<LocationModell> saveLocation(@RequestBody LocationModell locationModell) {
		LocationModell savedLocation = interfaceLocationService.saveLocation(locationModell);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedLocation);
	}

	@PutMapping("/update")
	public ResponseEntity<LocationModell> updateLocation(@RequestBody LocationModell locationModell) {
		LocationModell updatedLocation = interfaceLocationService.saveLocation(locationModell);
		return ResponseEntity.ok(updatedLocation);
	}

	@DeleteMapping("/delete/{idlocation}")
	public ResponseEntity<String> deleteLocation(@PathVariable int idlocation) {
		boolean isDeleted = interfaceLocationService.deleteLocation(idlocation);
		if (isDeleted) {
			return ResponseEntity.ok("Eliminación exitosa");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo eliminar, el elemento no existe");
		}
	}


}
