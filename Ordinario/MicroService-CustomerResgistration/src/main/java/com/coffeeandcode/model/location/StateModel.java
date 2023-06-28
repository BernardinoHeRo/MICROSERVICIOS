package com.coffeeandcode.model.location;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "estados")
public class StateModel {
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	//@Column(name = "nombre", nullable = false)
	private String nombre;

	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "pais", nullable = false)
	private CountryModel pais;

}
