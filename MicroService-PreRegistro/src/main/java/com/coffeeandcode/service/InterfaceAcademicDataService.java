package com.coffeeandcode.service;

import com.coffeeandcode.model.AcademicDataModel;

import java.util.List;
import java.util.Optional;

public interface InterfaceAcademicDataService {
	public List<AcademicDataModel> listallAcademicDatas();

	public Optional<AcademicDataModel> getAcademicDataById(int idAcademicData);

	public AcademicDataModel createAcademicData(AcademicDataModel academicDatamodel);

	public AcademicDataModel saveAcademicData(AcademicDataModel academicDatamodel);

	public AcademicDataModel updateAcademicData(int idAcademicData, AcademicDataModel academicDatamodel);

	public boolean deleteAcademicData(int idAcademicData);
}
