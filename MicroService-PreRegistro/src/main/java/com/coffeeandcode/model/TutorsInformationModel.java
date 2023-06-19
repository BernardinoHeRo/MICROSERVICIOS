package com.coffeeandcode.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@Table(name = "tutorsinformation")
public class TutorsInformationModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtutor;
	private String relationship;
	private String applicantsname;
	private String surname;
	/*===========================================================================
						Cardinalidades definidas
	===========================================================================*/
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private AddressModel address;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "date_contact_id")
	private DateContactModel dateContact;

}
