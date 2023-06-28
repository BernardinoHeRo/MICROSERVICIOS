package com.coffeeandcode.model.location;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "paises")
public class CountryModel {
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	//@Column(name = "nombre", nullable = false)
	private String nombre;
}
