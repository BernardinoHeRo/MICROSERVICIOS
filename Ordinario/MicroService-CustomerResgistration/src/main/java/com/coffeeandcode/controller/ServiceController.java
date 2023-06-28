package com.coffeeandcode.controller;

import com.coffeeandcode.model.ServiceModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/services")
public class ServiceController {
	@GetMapping("/add")
	public String AddServiceForm(Model model) {
		model.addAttribute("serviceNew", new ServiceModel());
		model.addAttribute("mensaje", "Registro de nuevo servicio");
		// Aquí puedes realizar cualquier lógica necesaria antes de mostrar el formulario
		// Por ejemplo, cargar datos adicionales para la vista o inicializar objetos

		return "/service/AddService"; // El nombre de la vista (sin la extensión .html)
	}

	@PostMapping("/save")
	public String saveService(@Valid @ModelAttribute("service") ServiceModel serviceModel,
	                          BindingResult bindingResultService,
	                          Model model) {
		if(bindingResultService.hasErrors() || serviceModel.getAmount()==0){
			model.addAttribute("mensaje","Llene los campos correctamente");
			model.addAttribute("serviceNew",serviceModel);
			return "/service/AddService";
		}
		return null;
	}
}
