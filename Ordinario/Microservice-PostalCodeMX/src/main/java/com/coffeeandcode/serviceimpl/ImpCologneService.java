package com.coffeeandcode.serviceimpl;

import com.coffeeandcode.model.CologneModel;
import com.coffeeandcode.repository.CologneRepository;
import com.coffeeandcode.service.InterCologneService;
import com.coffeeandcode.service.InterMunicipalityService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImpCologneService implements InterCologneService {
	private final CologneRepository cologneRepository;

	public ImpCologneService(CologneRepository cologneRepository) {
		this.cologneRepository = cologneRepository;
	}

	@Override
	public List<CologneModel> findAllColognes() {
		return (List<CologneModel>) cologneRepository.findAll();
	}

	@Override
	public Optional<CologneModel> findCologneById(int idCologne) {
		return cologneRepository.findById(idCologne);
	}

	@Override
	public CologneModel saveCologne(CologneModel cologneModel) {
		return cologneRepository.save(cologneModel);
	}

	@Override
	public boolean deleteCologne(int idCologne) {
		try {
			cologneRepository.deleteById(idCologne);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}
	@Override
	public List<CologneModel> findByPostalCode(int postalCode) {
		return cologneRepository.findByPostalCode(postalCode);
	}
}