package com.coffeeandcode.service;

import com.coffeeandcode.model.MunicipalityModel;

import java.util.List;
import java.util.Optional;

public interface InterMunicipalityService {
	public List<MunicipalityModel> findAllMunicipalitys();
	public Optional<MunicipalityModel> findMunicipalityById(int idMunicipality);
	public MunicipalityModel saveMunicipality(MunicipalityModel municipalityModel);
	public boolean deleteMunicipality(int idMunicipality);
}
