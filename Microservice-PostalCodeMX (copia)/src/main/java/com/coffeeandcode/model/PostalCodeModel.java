package com.coffeeandcode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cat_cp")
//@JsonIgnoreProperties({"municipio", "estado"})
public class PostalCodeModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcp")
	private int idCP;

	@ManyToOne
	@JoinColumn(name = "idmunicipio")
	private MunicipalityModel municipio;

	@ManyToOne
	@JoinColumn(name = "idestado")
	private StateModel estado;

	@Column(name = "cp")
	private int cp;

	@Column(name = "colonia")
	private String colonia;
}
