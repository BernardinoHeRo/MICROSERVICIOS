package com.coffeeandcode.serviceimpl;

import com.coffeeandcode.model.MunicipalityModel;
import com.coffeeandcode.repository.MunicipalityRepository;
import com.coffeeandcode.service.InterMunicipalityService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplMunicipalityService implements InterMunicipalityService {
	private final MunicipalityRepository municipalityRepository;

	public ImplMunicipalityService(MunicipalityRepository municipalityRepository) {
		this.municipalityRepository = municipalityRepository;
	}

	@Override
	public List<MunicipalityModel> findAllMunicipalitys() {
		return (List<MunicipalityModel>) municipalityRepository.findAll();
	}

	@Override
	public Optional<MunicipalityModel> findMunicipalityById(int idMunicipality) {
		return municipalityRepository.findById(idMunicipality);
	}

	@Override
	public MunicipalityModel saveMunicipality(MunicipalityModel municipalityModel) {
		return municipalityRepository.save(municipalityModel);
	}

	@Override
	public boolean deleteMunicipality(int idMunicipality) {
		try {
			municipalityRepository.deleteById(idMunicipality);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}
}
