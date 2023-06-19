package com.coffeeandcode.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "degreedetails")
public class DegreeDetailsModel{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddegreedetail;
	private String degreename;
	private String university;
	private String campus;
	//Se genera de forma aleatoria
	private int registrationnumber;
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
