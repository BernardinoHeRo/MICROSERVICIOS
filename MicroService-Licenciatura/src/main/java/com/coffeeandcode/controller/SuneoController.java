package com.coffeeandcode.controller;

import com.coffeeandcode.modell.LocationModell;
import com.coffeeandcode.modell.SuneoLocationRequest;
import com.coffeeandcode.modell.SuneoModell;
import com.coffeeandcode.service.InterfaceLocationService;
import com.coffeeandcode.service.InterfaceSuneoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/suneo")
public class SuneoController {

	private final InterfaceSuneoService interfaceSuneoService;
	private final InterfaceLocationService interfaceLocationService;

	@Autowired
	public SuneoController(InterfaceSuneoService interfaceSuneoService, InterfaceLocationService interfaceLocationService) {
		this.interfaceSuneoService = interfaceSuneoService;
		this.interfaceLocationService = interfaceLocationService;
	}

	@GetMapping("/list")
	public ResponseEntity<?> getAllLocations() {
		List<SuneoModell> suneoModellList = interfaceSuneoService.listAllProfessions();
		if (suneoModellList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La tabla está vacía");
		}
		return ResponseEntity.ok(suneoModellList);
	}


	@PostMapping("/add")
	public ResponseEntity<SuneoModell> saveSuneo(@RequestBody SuneoModell suneoModell) {
		SuneoModell savedSuneo = interfaceSuneoService.saveSuneo(suneoModell);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedSuneo);
	}

	@PutMapping("/update")
	public ResponseEntity<SuneoModell> updateSuneo(@RequestBody SuneoModell suneoModell) {
		SuneoModell updateSuneo = interfaceSuneoService.saveSuneo(suneoModell);
		return ResponseEntity.ok(updateSuneo);
	}

	@DeleteMapping("/delete/{idSuneo}")
	public ResponseEntity<String> deleteSuneo(@PathVariable int idSuneo) {
		boolean isDeleted = interfaceSuneoService.deleteSuneo(idSuneo);
		if (isDeleted) {
			return ResponseEntity.ok("Eliminación exitosa");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo eliminar, el elemento no existe");
		}
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveSuneoAndLocation(@RequestBody SuneoLocationRequest request) {
		LocationModell locationModell = request.getLocationModell();
		SuneoModell suneoModell = request.getSuneoModell();

		LocationModell savedLocationModell = interfaceLocationService.saveLocation(locationModell);
		suneoModell.setLocationModell(locationModell);
		SuneoModell savedSuneoModel = interfaceSuneoService.saveSuneo(suneoModell);

		if (savedSuneoModel != null) {
			// Convertir el objeto a JSON
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				String suneoJson = objectMapper.writeValueAsString(savedSuneoModel);
				return ResponseEntity.ok(suneoJson);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al convertir a JSON");
			}
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al almacenar el objeto SuneoModell");
		}
	}

	@PutMapping("/updatedual")
	public ResponseEntity<String> updateSuneoAndLocation(@RequestBody SuneoLocationRequest request) {
		LocationModell locationModell = request.getLocationModell();
		SuneoModell suneoModell = request.getSuneoModell();

		LocationModell savedLocationModell = interfaceLocationService.saveLocation(locationModell);
		suneoModell.setLocationModell(locationModell);
		SuneoModell saveSuneoModel = interfaceSuneoService.saveSuneo(suneoModell);
		// Resto del código para procesar los modelos
		long idAuxLocation = interfaceLocationService.getLastLocationId();

		// Crear un objeto que contenga los datos combinados
		SuneoLocationRequest combinedData = new SuneoLocationRequest();
		combinedData.setLocationModell(interfaceLocationService.getLocationById((int) idAuxLocation).get());
		combinedData.setSuneoModell(suneoModell);

		// Convertir el objeto a JSON
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String combinedJson = objectMapper.writeValueAsString(combinedData);
			return ResponseEntity.ok(combinedJson);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al convertir a JSON");
		}
	}
	@GetMapping("/searchprofessions")
	public ResponseEntity<?> listAllProfessionsByString(@RequestParam("searchValue") String searchValue) {
		List<SuneoModell> professions = interfaceSuneoService.listAllProfessionsByString(searchValue);

		if (professions.isEmpty()) {
			return ResponseEntity.ok("Ninguna coincidencia encontrada");
		}

		return ResponseEntity.ok(professions);
	}


}
