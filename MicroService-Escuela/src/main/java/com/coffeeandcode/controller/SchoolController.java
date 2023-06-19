package com.coffeeandcode.controller;

import com.coffeeandcode.modell.SchoolModell;
import com.coffeeandcode.service.InterfaceSchoolService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/schools")
public class SchoolController {
	private final InterfaceSchoolService interfaceSchoolService;

	public SchoolController(@Autowired InterfaceSchoolService interfaceSchoolService) {
		this.interfaceSchoolService = interfaceSchoolService;
	}

	@GetMapping("/list")
	public List<SchoolModell> listAllSchools() {
		//List<SchoolModell> schoolModellList = interfaceSchoolService.listAllSchools();
		//Gson gson = new Gson();
		//String jsonSchoolls = gson.toJson(schoolModellList);
		return interfaceSchoolService.listAllSchools();
	}

	@PostMapping("/add")
	public int addSchool(@RequestBody SchoolModell schoolModell) {
		int idAux;
		idAux = schoolModell.getId();
		//System.out.println("El id de llegada; "+idAux);
		SchoolModell savedSchool = interfaceSchoolService.saveSchool(schoolModell);
		//System.out.println("El id de salida es: " + savedSchool.getId());
		Gson gson = new Gson();
		String json = gson.toJson(savedSchool);
		if (idAux != savedSchool.getId()) {
			return 1;
		} else {
			return 0;
		}
	}


	@GetMapping("/list/{idSchool}")
	public ResponseEntity<?> viewInfo(@PathVariable Integer idSchool) {
		Optional<SchoolModell> schoolOpt = interfaceSchoolService.listSchoolById(idSchool);
		if (schoolOpt.isPresent()) {
			SchoolModell schoolModell = schoolOpt.get();
			return ResponseEntity.ok(schoolModell); // Retorna el modelo si se encuentra
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La información no existe en la DB"); // Retorna un mensaje de error si no se encuentra el modelo
		}
	}

	@GetMapping("/seacrh/{nameSchool}")
	public ResponseEntity<?> viewInfo(@PathVariable String nameSchool) {
		System.out.println("La escuela que buscas es: " + nameSchool);
		List<SchoolModell> schoolModellList = interfaceSchoolService.listSchoolsByName(nameSchool);
		if (schoolModellList.isEmpty()) {
			String errorMessage = "No se encontró información";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
		} else {
			return ResponseEntity.ok(schoolModellList);
		}
	}


	@PutMapping("/update")
	public ResponseEntity<?> updateSchool(@RequestBody SchoolModell schoolModell) {
		Gson gson = new Gson();
		String jsonSchoolModell = gson.toJson(schoolModell);

		SchoolModell savedSchool = interfaceSchoolService.saveSchool(schoolModell);
		String json = gson.toJson(savedSchool);
		if (jsonSchoolModell.equals(json)) {
			return ResponseEntity.ok(json); // Return the updated model if the modification is successful
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se pudo actualizar la información"); // Return an error message if the modification fails
		}
	}


	@DeleteMapping("/delete/{idSchool}")
	public String deleteSchool(@PathVariable Integer idSchool) {
		System.out.println("Id de retorno : " + interfaceSchoolService.deleteSchool(idSchool));
		if (interfaceSchoolService.deleteSchool(idSchool) == 1) {
			return "Eliminacion exitosa:    " + 1;
		} else {
			return "No se pudo eliminar";
		}
	}

	@DeleteMapping("/deletename/{nameSchool}")
	public ResponseEntity<?> deleteSchoolByName(@PathVariable String nameSchool) {
		System.out.println("La escuela a eliminar es: " + nameSchool);
		// Realizar la lógica de eliminación en la base de datos o repositorio
		boolean deletionSuccessful = interfaceSchoolService.deleteSchoolByName(nameSchool);
		if (deletionSuccessful) {
			return ResponseEntity.ok("La escuela fue eliminada exitosamente");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la escuela");
		}
	}


}
