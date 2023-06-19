package com.coffeeandcode.service;

import com.coffeeandcode.model.DegreeDetailsModel;

import java.util.List;
import java.util.Optional;

public interface InterfaceDegreeDetailsService {
	public List<DegreeDetailsModel> listallDegreeDetail();

	public Optional<DegreeDetailsModel> getDegreeDetailById(int idDegreeDetail);

	public DegreeDetailsModel createDegreeDetail(DegreeDetailsModel degreeDetailsModel);
	public DegreeDetailsModel saveDegreeDetail(DegreeDetailsModel degreeDetailsModel);

	public DegreeDetailsModel updateDegreeDetail(int idDegreeDetail, DegreeDetailsModel degreeDetailsModel);

	public boolean deleteDegreeDetail(int idDegreeDetail);
}
