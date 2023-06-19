package com.coffeeandcode.serviceimpl;

import com.coffeeandcode.modell.SuneoModell;
import com.coffeeandcode.repository.SuneroRepository;
import com.coffeeandcode.service.InterfaceSuneoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplSuneoService implements InterfaceSuneoService {
	private final SuneroRepository suneroRepository;

	@Autowired
	public ImplSuneoService(SuneroRepository suneroRepository) {
		this.suneroRepository = suneroRepository;
	}

	@Override
	public List<SuneoModell> listAllProfessions() {
		return suneroRepository.findAll();
	}

	@Override
	public Optional<SuneoModell> getSuneoById(int idSuneo) {
		return suneroRepository.findById(idSuneo);
	}

	@Override
	public SuneoModell saveSuneo(SuneoModell suneoModell) {
		return suneroRepository.save(suneoModell);
	}

	@Override
	public boolean deleteSuneo(int idsuneo) {
		Optional<SuneoModell> suneo = suneroRepository.findById(idsuneo);
		if(suneo.isPresent()){
			suneroRepository.deleteById(idsuneo);
			return true;
		}
		return false;
	}

	@Override
	public List<SuneoModell> listAllProfessionsByString(String nameCampusDegree) {
		return suneroRepository.searchProfessions(nameCampusDegree );
	}
}
