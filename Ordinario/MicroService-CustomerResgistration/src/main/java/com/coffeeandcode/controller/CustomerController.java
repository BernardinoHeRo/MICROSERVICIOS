package com.coffeeandcode.controller;

import com.coffeeandcode.model.CustomerModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	@GetMapping("/add")
	public String AddCustomerForm(Model model) {
		model.addAttribute("customerNew", new CustomerModel());
		model.addAttribute("mensaje", "Registro de nuevo cliente");
		// Aquí puedes realizar cualquier lógica necesaria antes de mostrar el formulario
		// Por ejemplo, cargar datos adicionales para la vista o inicializar objetos

		return "/customer/AddCustomer"; // El nombre de la vista (sin la extensión .html)
	}
}
