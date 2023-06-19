package com.coffeeandcode.modell;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "professions")
@Getter
@Setter
@ToString
public class SuneoModell {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idprofession;
	private String nameuniversity;
	//Puede o no tener campus
	private String universitycampus;
	private String degreeprogramoffered;
	//Aquí irá la ubicación
	/*
	===================================================================
	===================================================================
				SuneoModell - LocationModell
							ManyToOne
		Pues varias carreras pueden tener una ubicación en común
	===================================================================
	===================================================================
	 */
	@ManyToOne
	@JoinColumn(name = "locationidfk")
	private LocationModell locationModell;

	public SuneoModell() {
	}

	public SuneoModell(int idprofession, String nameuniversity, String universitycampus, String degreeprogramoffered, LocationModell locationModell) {
		this.idprofession = idprofession;
		this.nameuniversity = nameuniversity;
		this.universitycampus = universitycampus;
		this.degreeprogramoffered = degreeprogramoffered;
		this.locationModell = locationModell;
	}
}
