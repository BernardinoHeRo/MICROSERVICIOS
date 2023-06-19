package com.coffeeandcode.service;

import com.coffeeandcode.model.PersonalDataModel;

import java.util.List;
import java.util.Optional;

public interface InterfacePersonalDataService {
	public List<PersonalDataModel> listallPersonalData();
	public Optional<PersonalDataModel> getPersonalDataById(int idPersonalDate);

	public PersonalDataModel createPersonalData(PersonalDataModel personalDataModel);

	public PersonalDataModel savePersonalData(PersonalDataModel personalDataModel);

	public PersonalDataModel updatePersonalData(int idPeronalDate, PersonalDataModel personalDataModel);

	public boolean deletePersonalData(int idPersonalData);

	public List<PersonalDataModel> getAllPersonalData();
	public List<PersonalDataModel> obtenerPersonalDataListDesdeLaBaseDeDatos();
}
