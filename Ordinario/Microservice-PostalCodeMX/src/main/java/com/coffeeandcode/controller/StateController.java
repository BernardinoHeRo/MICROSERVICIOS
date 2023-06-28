package com.coffeeandcode.controller;

import com.coffeeandcode.model.StateModel;
import com.coffeeandcode.service.InterStateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {
	private final InterStateService interStateService;

	public StateController(InterStateService interStateService) {
		this.interStateService = interStateService;
	}

	@GetMapping("/read")
	public ResponseEntity<List<StateModel>>read(){
		List<StateModel> stateModelList = interStateService.findAllStates();
		if (stateModelList.isEmpty()) {
			return ResponseEntity.noContent().build(); // Retorna una respuesta 204 No Content si no hay elementos en la base de datos
		}
		return ResponseEntity.ok().body(stateModelList); // Retorna una respuesta 200 OK con la lista de elementos en formato JSON
	}
}
