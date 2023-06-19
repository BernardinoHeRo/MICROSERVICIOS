package com.coffeeandcode.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "personaldate")
public class PersonalDataModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpersonaldate;
	private String applicantsname;
	private String surname;
	private String curp;
	private String dateofbirth;
	private String placeofbirth;
	/*===========================================================================
						Cardinalidades definidas
	===========================================================================*/
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private AddressModel address;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "date_contact_id")
	private DateContactModel dateContact;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tutor_id")
	private TutorsInformationModel tutor;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "academic_date_id")
	private AcademicDataModel academicDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "degree_details_id")
	private DegreeDetailsModel degreeDetails;


}
