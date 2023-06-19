package com.coffeeandcode.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class AddressModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idaddress;
	private String country;
	private String state;
	private String municipality;
	private String street;
	private int housenumber;
	private int postalcode;
	/*===========================================================================
						Cardinalidades definidas
	===========================================================================*/
	@JsonIgnore
	@OneToOne(mappedBy = "address")
	private PersonalDataModel personalData;
	@JsonIgnore
	@OneToOne(mappedBy = "address")
	private TutorsInformationModel tutor;
	@JsonIgnore
	@OneToOne(mappedBy = "address")
	private AcademicDataModel academicDate;
	@JsonIgnore
	@OneToOne(mappedBy = "address")
	private DegreeDetailsModel degreeDetails;
}
