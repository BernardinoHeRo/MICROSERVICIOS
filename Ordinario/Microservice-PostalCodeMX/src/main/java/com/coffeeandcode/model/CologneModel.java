package com.coffeeandcode.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "colonias")
public class CologneModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "ciudad")
	private String ciudad;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "municipio")
	private MunicipalityModel municipio;

	@Column(name = "asentamiento")
	private String asentamiento;

	@Column(name = "codigo_postal")
	private int codigoPostal;
}
