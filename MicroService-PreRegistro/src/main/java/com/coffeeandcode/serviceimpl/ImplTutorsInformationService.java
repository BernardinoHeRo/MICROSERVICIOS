package com.coffeeandcode.serviceimpl;

import com.coffeeandcode.model.TutorsInformationModel;
import com.coffeeandcode.repository.TutorsInformationRepository;
import com.coffeeandcode.service.InterfaceTutorsInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ImplTutorsInformationService implements InterfaceTutorsInformationService {
	private final TutorsInformationRepository tutorsInformationRepository;

	@Autowired
	public ImplTutorsInformationService(TutorsInformationRepository tutorsInformationRepository) {
		this.tutorsInformationRepository = tutorsInformationRepository;
	}

	@Override
	public List<TutorsInformationModel> listAllTutors() {
		return tutorsInformationRepository.findAll();
	}

	@Override
	public Optional<TutorsInformationModel> getTutorById(int idTutor) {
		return tutorsInformationRepository.findById(idTutor);
	}

	@Override
	public TutorsInformationModel createTutor(TutorsInformationModel TutorsInformationModel) {
		return null;
	}

	@Override
	public TutorsInformationModel saveTutor(TutorsInformationModel TutorsInformationModel) {
		return tutorsInformationRepository.save(TutorsInformationModel);
	}


	@Override
	public TutorsInformationModel updateTutor(int idTutor, TutorsInformationModel TutorsInformationModel) {
		Optional<TutorsInformationModel> optionalPersonalData = tutorsInformationRepository.findById(idTutor);

		if (optionalPersonalData.isPresent()) {
			TutorsInformationModel existingPersonalData = optionalPersonalData.get();
			/*
			// Actualizar los campos necesarios en el objeto existingPersonalData
			existingPersonalData.setApplicantsname(TutorsInformationModel.getApplicantsname());
			existingPersonalData.setSurname(TutorsInformationModel.getSurname());
			existingPersonalData.setCurp(TutorsInformationModel.getCurp());
			existingPersonalData.setDateofbirth(TutorsInformationModel.getDateofbirth());
			existingPersonalData.setPlaceofbirth(TutorsInformationModel.getPlaceofbirth());
			// Actualizar otras propiedades si es necesario
*/
			// Guardar los cambios en la base de datos
			TutorsInformationModel updatedPersonalData = tutorsInformationRepository.save(existingPersonalData);
			return updatedPersonalData;
		} else {
			throw new NoSuchElementException("El modelo para el ID " + idTutor + " no existe");
		}
	}


	@Override
	public boolean deleteTutor(int idTutor) {
		Optional<TutorsInformationModel> tutorsInformationModel = tutorsInformationRepository.findById(idTutor);

		if (tutorsInformationModel.isPresent()) {
			tutorsInformationRepository.deleteById(idTutor);
			return true;
		} else {
			return false;
		}
	}
}
