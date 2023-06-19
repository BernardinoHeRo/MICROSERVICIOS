package com.coffeeandcode.service;

import com.coffeeandcode.model.PersonalDataModel;
import com.coffeeandcode.model.TutorsInformationModel;

import java.util.List;
import java.util.Optional;

public interface InterfaceTutorsInformationService {
	public List<TutorsInformationModel> listAllTutors();

	public Optional<TutorsInformationModel> getTutorById(int idTutor);

	public TutorsInformationModel createTutor(TutorsInformationModel tutorsInformationModel);
	public TutorsInformationModel saveTutor(TutorsInformationModel tutorsInformationModel);

	public TutorsInformationModel updateTutor(int idTutor, TutorsInformationModel tutorsInformationModel);

	public boolean deleteTutor(int idTutor);
}
