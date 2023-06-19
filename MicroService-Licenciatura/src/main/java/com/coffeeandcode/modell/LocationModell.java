package com.coffeeandcode.modell;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "locations")
@Getter
@Setter
@ToString
public class LocationModell {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idlocation;
	private String state;
	private String municipality;
	private String postalcode;


	public LocationModell() {
	}
	public LocationModell(int idlocation, String state, String municipality, String postalcode) {
		this.idlocation = idlocation;
		this.state = state;
		this.municipality = municipality;
		this.postalcode = postalcode;
	}
}
