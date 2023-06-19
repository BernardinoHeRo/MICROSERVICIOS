package com.coffeeandcode.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "academicdate")
public class AcademicDataModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idacademicdate;
	private String highschooloforigin;
	private String fieldofstudy;
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
