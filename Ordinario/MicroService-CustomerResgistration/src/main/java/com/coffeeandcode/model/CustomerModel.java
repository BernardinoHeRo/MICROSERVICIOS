package com.coffeeandcode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "records")
public class CustomerModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idrecord;



	//Info general
	private String names;
	private String lastname;
	private String motherslastname;
	private int age;
	//Esta medida debe estar en Kg ejemplo 68.5 Kg
	private float weight;
	//Esta medida debe estar en cm ejemplo 182.5 cm
	private float height;



	//Condicion medica
	private String medicalcondition;
	private String druguse;
	private String bloodpressure;



	//Domicilio
	private String state;
	private int postalcode;
	private String cologne;
	private String municipality;
	private String housenumber;


	//Cardinalida
	@OneToMany(mappedBy = "customer")
	private List<PaymentServiceModel> payments;
}
