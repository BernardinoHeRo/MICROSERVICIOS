package com.coffeeandcode.service;

import com.coffeeandcode.model.CologneModel;

import java.util.List;
import java.util.Optional;

public interface InterCologneService {
	public List<CologneModel> findAllColognes();

	public Optional<CologneModel> findCologneById(int idCologne);

	public CologneModel saveCologne(CologneModel cologneModel);

	public boolean deleteCologne(int idCologne);
	public List<CologneModel> findByPostalCode(int postalCode);

}
