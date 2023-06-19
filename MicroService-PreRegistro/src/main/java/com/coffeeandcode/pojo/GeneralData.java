package com.coffeeandcode.pojo;

import com.coffeeandcode.model.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GeneralData {
	private PersonalDataModel personalData;
	private AddressModel personalDataAddress;
	private DateContactModel personalDataDateContact;

	private TutorsInformationModel tutor;
	private AddressModel tutorAddress;
	private DateContactModel tutorDateContact;

	private AcademicDataModel academicDate;
	private AddressModel academicDateAddress;
	private DateContactModel academicDateDateContact;

	private DegreeDetailsModel degreeDetails;
	private AddressModel degreeDetailsAddress;
	private DateContactModel degreeDetailsDateContact;
}
