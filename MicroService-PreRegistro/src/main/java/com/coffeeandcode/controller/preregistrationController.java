package com.coffeeandcode.controller;

import com.coffeeandcode.model.*;
import com.coffeeandcode.pojo.GeneralData;
import com.coffeeandcode.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/preregistrations")
public class preregistrationController {
	private final InterfacePersonalDataService interfacePersonalDataService;
	private final InterfaceDateContactService interfaceDateContactService;
	private final InterfaceAddressService interfaceAddressService;
	final InterfaceAcademicDataService interfaceAcademicDataService;
	private final InterfaceTutorsInformationService interfaceTutorsInformationService;
	private final InterfaceDegreeDetailsService interfaceDegreeDetailsService;

	@Autowired
	public preregistrationController(InterfacePersonalDataService interfacePersonalDataService, InterfaceDateContactService interfaceDateContactService, InterfaceAddressService interfaceAddressService, InterfaceAcademicDataService interfaceAcademicDataService, InterfaceTutorsInformationService interfaceTutorsInformationService, InterfaceDegreeDetailsService interfaceDegreeDetailsService) {
		this.interfacePersonalDataService = interfacePersonalDataService;
		this.interfaceDateContactService = interfaceDateContactService;
		this.interfaceAddressService = interfaceAddressService;
		this.interfaceAcademicDataService = interfaceAcademicDataService;
		this.interfaceTutorsInformationService = interfaceTutorsInformationService;
		this.interfaceDegreeDetailsService = interfaceDegreeDetailsService;
	}

	@PostMapping("/save")
	public ResponseEntity<Object> createPersonalData(@RequestBody GeneralData generalData) {
		PersonalDataModel personalData = generalData.getPersonalData();

		DegreeDetailsModel degreeDetails = generalData.getDegreeDetails();
		AddressModel degreeDetailsAddress = generalData.getDegreeDetailsAddress();
		DateContactModel degreeDetailsDateContact = generalData.getDegreeDetailsDateContact();
		degreeDetails.setAddress(degreeDetailsAddress);
		degreeDetails.setDateContact(degreeDetailsDateContact);
		personalData.setDegreeDetails(degreeDetails);

		AcademicDataModel academicDate = generalData.getAcademicDate();
		AddressModel academicDateAddress = generalData.getAcademicDateAddress();
		DateContactModel academicDateDateContact = generalData.getAcademicDateDateContact();
		academicDate.setAddress(academicDateAddress);
		academicDate.setDateContact(academicDateDateContact);
		personalData.setAcademicDate(academicDate);

		TutorsInformationModel tutor = generalData.getTutor();
		AddressModel tutorAddress = generalData.getTutorAddress();
		DateContactModel tutorDateContact = generalData.getTutorDateContact();
		tutor.setAddress(tutorAddress);
		tutor.setDateContact(tutorDateContact);
		personalData.setTutor(tutor);

		AddressModel personalDataAddress = generalData.getPersonalDataAddress();
		DateContactModel personalDataDateContact = generalData.getPersonalDataDateContact();
		personalData.setAddress(personalDataAddress);
		personalData.setDateContact(personalDataDateContact);

		interfacePersonalDataService.savePersonalData(personalData);
		// Puedes agregar lógica adicional aquí si es necesario

		// Devuelve el objeto de la clase contenedora sin modificar
		return ResponseEntity.ok(personalData);
	}

	@GetMapping("/list")
	public ResponseEntity<?> getAllPersonalData() {
		List<PersonalDataModel> personalDataList = interfacePersonalDataService.getAllPersonalData();
		System.out.println(personalDataList);
		if (personalDataList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Base de datos vacía");
		} else {
			return ResponseEntity.ok(personalDataList);
		}
	}

	@GetMapping("/read")
	public ResponseEntity<Object> listar() {
		List<GeneralData> generalDataList = new ArrayList<>();

		// Obtener los datos de la base de datos o de donde estén almacenados
		List<PersonalDataModel> personalDataList = interfacePersonalDataService.obtenerPersonalDataListDesdeLaBaseDeDatos();

		// Recorrer la lista de PersonalDataModel y crear los objetos GeneralData correspondientes
		for (PersonalDataModel personalData : personalDataList) {
			GeneralData generalData = new GeneralData();
			generalData.setPersonalData(personalData);

			DegreeDetailsModel degreeDetails = personalData.getDegreeDetails();
			AddressModel degreeDetailsAddress = degreeDetails.getAddress();
			DateContactModel degreeDetailsDateContact = degreeDetails.getDateContact();

			generalData.setDegreeDetails(degreeDetails);
			generalData.setDegreeDetailsAddress(degreeDetailsAddress);
			generalData.setDegreeDetailsDateContact(degreeDetailsDateContact);

			AcademicDataModel academicDate = personalData.getAcademicDate();
			AddressModel academicDateAddress = academicDate.getAddress();
			DateContactModel academicDateDateContact = academicDate.getDateContact();

			generalData.setAcademicDate(academicDate);
			generalData.setAcademicDateAddress(academicDateAddress);
			generalData.setAcademicDateDateContact(academicDateDateContact);

			TutorsInformationModel tutor = personalData.getTutor();
			AddressModel tutorAddress = tutor.getAddress();
			DateContactModel tutorDateContact = tutor.getDateContact();

			generalData.setTutor(tutor);
			generalData.setTutorAddress(tutorAddress);
			generalData.setTutorDateContact(tutorDateContact);

			AddressModel personalDataAddress = personalData.getAddress();
			DateContactModel personalDataDateContact = personalData.getDateContact();

			generalData.setPersonalDataAddress(personalDataAddress);
			generalData.setPersonalDataDateContact(personalDataDateContact);

			generalDataList.add(generalData);
		}
		// Devolver la lista de GeneralData
		return ResponseEntity.ok(generalDataList);
	}


}
