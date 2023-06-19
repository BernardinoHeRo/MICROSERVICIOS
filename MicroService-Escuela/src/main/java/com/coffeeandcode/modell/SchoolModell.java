package com.coffeeandcode.modell;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "highschools")
public class SchoolModell {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nameschool;
	private String country;
	private String state;
	private String municipality;
	private int postalcode;

	public SchoolModell() {
	}

	public SchoolModell(int id, String nameschool, String country, String state, String municipality, int postalcode) {
		this.id = id;
		this.nameschool = nameschool;
		this.country = country;
		this.state = state;
		this.municipality = municipality;
		this.postalcode = postalcode;
	}
}
