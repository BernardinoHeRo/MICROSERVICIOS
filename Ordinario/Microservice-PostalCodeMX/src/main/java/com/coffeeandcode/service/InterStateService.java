package com.coffeeandcode.service;

import com.coffeeandcode.model.StateModel;

import java.util.List;
import java.util.Optional;

public interface InterStateService {
	public List<StateModel> findAllStates();
	public Optional<StateModel> findStateById(int idState);
	public StateModel saveState(StateModel stateModel);
	public boolean deleteState(int idState);
}
