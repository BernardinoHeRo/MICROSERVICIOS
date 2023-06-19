package com.coffeeandcode.controller;

import com.coffeeandcode.model.PersonalDataModel;
import com.coffeeandcode.service.InterfacePersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personaldata")

public class PersonalDataController {
	private final InterfacePersonalDataService interfacePersonalDataService;

	@Autowired
	public PersonalDataController(InterfacePersonalDataService interfacePersonalDataService) {
		this.interfacePersonalDataService = interfacePersonalDataService;
	}

	@PostMapping("/save")
	public ResponseEntity<Object> createPersonalData(@RequestBody PersonalDataModel personalData) {
		try {
			PersonalDataModel savedPersonalData = interfacePersonalDataService.savePersonalData(personalData);
			return ResponseEntity.ok(savedPersonalData);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al almacenar la información");
		}
	}


	@GetMapping("/list")
	public ResponseEntity<Object> index() {
		List<PersonalDataModel> personalDataList = interfacePersonalDataService.listallPersonalData();

		if (personalDataList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("La tabla está vacía");
		} else {
			return ResponseEntity.ok(personalDataList);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updatePersonalData(@PathVariable int id, @RequestBody PersonalDataModel personalData) {
		try {
			PersonalDataModel updatedPersonalData = interfacePersonalDataService.updatePersonalData(id, personalData);
			return ResponseEntity.ok(updatedPersonalData);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No fue posible actualizar datos pues no se encuentra el id con la informacion");
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePersonalData(@PathVariable int id) {
		boolean deleted = interfacePersonalDataService.deletePersonalData(id);

		if (deleted) {
			return ResponseEntity.ok("Eliminación exitosa");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo eliminar el elemento");
		}
	}

	@GetMapping("/search/{id}")
	public ResponseEntity<Object> getPersonalData(@PathVariable int id) {
		Optional<PersonalDataModel> personalDataOptional = interfacePersonalDataService.getPersonalDataById(id);

		if (personalDataOptional.isPresent()) {
			PersonalDataModel personalData = personalDataOptional.get();
			return ResponseEntity.ok(personalData);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró ningún dato relacionado con el ID: " + id);
		}
	}
}
