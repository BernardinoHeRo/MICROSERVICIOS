package com.coffeeandcode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class PaymentServiceModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpayment;
	private String serviceperiod;
	private float paymentamount;
	private String startdate;
	private String cutoffdate;
	private String paymentstatus;

	///Cardinalidad
	@ManyToOne
	@JoinColumn(name = "idservice")
	private ServiceModel service;

	@ManyToOne
	@JoinColumn(name = "idrecord")
	private CustomerModel customer;

}
