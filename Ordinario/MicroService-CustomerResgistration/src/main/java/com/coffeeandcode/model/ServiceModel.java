package com.coffeeandcode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "services")
public class ServiceModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idservice;
	private String paymentconcept;
	@NotNull
	private float amount;
	private String descriptionpayment;

	//Cardinalidad
	@OneToMany(mappedBy = "service")
	private List<PaymentServiceModel> payments;
}
