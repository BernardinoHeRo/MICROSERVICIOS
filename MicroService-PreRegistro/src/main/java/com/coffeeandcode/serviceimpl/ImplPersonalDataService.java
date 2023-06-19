package com.coffeeandcode.serviceimpl;

import com.coffeeandcode.model.PersonalDataModel;
import com.coffeeandcode.pojo.GeneralData;
import com.coffeeandcode.repository.*;
import com.coffeeandcode.service.InterfacePersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ImplPersonalDataService implements InterfacePersonalDataService {
	private final PersonalDataRepository personalDataRepository;
	private final AcademicDataRepository academicDataRepository;
	private final AddressRepository addressRepository;
	private final DateContactRepository dateContactRepository;
	private final DegreeDetailsRepository degreeDetailsRepository;
	private final TutorsInformationRepository tutorsInformationRepository;

	@Autowired
	public ImplPersonalDataService(PersonalDataRepository personalDataRepository, AcademicDataRepository academicDataRepository, AddressRepository addressRepository, DateContactRepository dateContactRepository, DegreeDetailsRepository degreeDetailsRepository, TutorsInformationRepository tutorsInformationRepository) {
		this.personalDataRepository = personalDataRepository;
		this.academicDataRepository = academicDataRepository;
		this.addressRepository = addressRepository;
		this.dateContactRepository = dateContactRepository;
		this.degreeDetailsRepository = degreeDetailsRepository;
		this.tutorsInformationRepository = tutorsInformationRepository;
	}

	@Override
	public List<PersonalDataModel> listallPersonalData() {
		return personalDataRepository.findAll();
	}

	@Override
	public Optional<PersonalDataModel> getPersonalDataById(int idPersonalDate) {
		return personalDataRepository.findById(idPersonalDate);
	}

	@Override
	public PersonalDataModel createPersonalData(PersonalDataModel personalDataModel) {
		return null;
	}

	@Override
	public PersonalDataModel savePersonalData(PersonalDataModel personalDataModel) {
		return personalDataRepository.save(personalDataModel);
	}


	@Override
	public PersonalDataModel updatePersonalData(int idPersonalDate, PersonalDataModel personalDataModel) {
		Optional<PersonalDataModel> optionalPersonalData = personalDataRepository.findById(idPersonalDate);

		if (optionalPersonalData.isPresent()) {
			PersonalDataModel existingPersonalData = optionalPersonalData.get();

			// Actualizar los campos necesarios en el objeto existingPersonalData
			existingPersonalData.setApplicantsname(personalDataModel.getApplicantsname());
			existingPersonalData.setSurname(personalDataModel.getSurname());
			existingPersonalData.setCurp(personalDataModel.getCurp());
			existingPersonalData.setDateofbirth(personalDataModel.getDateofbirth());
			existingPersonalData.setPlaceofbirth(personalDataModel.getPlaceofbirth());
			// Actualizar otras propiedades si es necesario

			// Guardar los cambios en la base de datos
			PersonalDataModel updatedPersonalData = personalDataRepository.save(existingPersonalData);
			return updatedPersonalData;
		} else {
			throw new NoSuchElementException("El modelo para el ID " + idPersonalDate + " no existe");
		}
	}


	@Override
	public boolean deletePersonalData(int idPersonalData) {
		Optional<PersonalDataModel> personalDataOptional = personalDataRepository.findById(idPersonalData);

		if (personalDataOptional.isPresent()) {
			personalDataRepository.deleteById(idPersonalData);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<PersonalDataModel> getAllPersonalData() {
		return personalDataRepository.findAll();
	}


	public List<PersonalDataModel> obtenerPersonalDataListDesdeLaBaseDeDatos() {
		// Realiza la consulta a la base de datos para obtener la lista de PersonalDataModel
		List<PersonalDataModel> personalDataList = personalDataRepository.findAll();

		return personalDataList;
	}

}
