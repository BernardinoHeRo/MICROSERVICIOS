package com.coffeeandcode.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "datecontact")
public class DateContactModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddatecontact;
	private String landlinephone;
	private String cellphone;
	private String email;
	/*===========================================================================
						Cardinalidades definidas
	===========================================================================*/
	//@JsonBackReference
	@JsonIgnore
	@OneToOne(mappedBy = "dateContact")
	private PersonalDataModel personalData;
	@JsonIgnore
	@OneToOne(mappedBy = "dateContact")
	private TutorsInformationModel tutor;
	@JsonIgnore
	@OneToOne(mappedBy = "dateContact")
	private AcademicDataModel academicDate;
	@JsonIgnore
	@OneToOne(mappedBy = "dateContact")
	private DegreeDetailsModel degreeDetails;


}
