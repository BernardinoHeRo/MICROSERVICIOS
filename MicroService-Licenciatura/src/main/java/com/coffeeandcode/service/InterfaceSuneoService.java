package com.coffeeandcode.service;

import com.coffeeandcode.modell.SuneoModell;

import java.util.List;
import java.util.Optional;

public interface InterfaceSuneoService {
	public List<SuneoModell> listAllProfessions();

	public Optional<SuneoModell> getSuneoById(int idSuneo);

	public SuneoModell saveSuneo(SuneoModell suneoModell);

	public boolean deleteSuneo(int idsuneo);

	public List<SuneoModell> listAllProfessionsByString(String nameCampusDegree);
}
