package com.coffeeandcode.serviceimpl;

import com.coffeeandcode.model.AcademicDataModel;
import com.coffeeandcode.repository.AcademicDataRepository;
import com.coffeeandcode.service.InterfaceAcademicDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ImplAcademicDataService implements InterfaceAcademicDataService {
	private final AcademicDataRepository academicDataRepository;

	@Autowired
	public ImplAcademicDataService(AcademicDataRepository academicDataRepository) {
		this.academicDataRepository = academicDataRepository;
	}

	@Override
	public List<AcademicDataModel> listallAcademicDatas() {

		return academicDataRepository.findAll();
	}

	@Override
	public Optional<AcademicDataModel> getAcademicDataById(int idAcademicData) {
		return academicDataRepository.findById(idAcademicData);
	}

	@Override
	public AcademicDataModel createAcademicData(AcademicDataModel academicDataModel) {
		return null;
	}

	@Override
	public AcademicDataModel saveAcademicData(AcademicDataModel academicDataModel) {
		return academicDataRepository.save(academicDataModel);
	}


	@Override
	public AcademicDataModel updateAcademicData(int idAcademicData, AcademicDataModel academicDataModel) {
		Optional<AcademicDataModel> optionalPersonalData = academicDataRepository.findById(idAcademicData);

		if (optionalPersonalData.isPresent()) {
			AcademicDataModel existingPersonalData = optionalPersonalData.get();
			/*
			// Actualizar los campos necesarios en el objeto existingPersonalData
			existingPersonalData.setApplicantsname(AcademicDataModel.getApplicantsname());
			existingPersonalData.setSurname(AcademicDataModel.getSurname());
			existingPersonalData.setCurp(AcademicDataModel.getCurp());
			existingPersonalData.setDateofbirth(AcademicDataModel.getDateofbirth());
			existingPersonalData.setPlaceofbirth(AcademicDataModel.getPlaceofbirth());
			// Actualizar otras propiedades si es necesario
*/
			// Guardar los cambios en la base de datos
			AcademicDataModel updatedPersonalData = academicDataRepository.save(existingPersonalData);
			return updatedPersonalData;
		} else {
			throw new NoSuchElementException("El modelo para el ID " + idAcademicData + " no existe");
		}
	}


	@Override
	public boolean deleteAcademicData(int idAcademicData) {
		Optional<AcademicDataModel> academicDataModel = academicDataRepository.findById(idAcademicData);

		if (academicDataModel.isPresent()) {
			academicDataRepository.deleteById(idAcademicData);
			return true;
		} else {
			return false;
		}
	}
}
