package com.coffeeandcode.serviceimpl;

import com.coffeeandcode.model.StateModel;
import com.coffeeandcode.repository.StateRepository;
import com.coffeeandcode.service.InterStateService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplStateService implements InterStateService {
	private final StateRepository stateRepository;

	public ImplStateService(StateRepository stateRepository) {
		this.stateRepository = stateRepository;
	}

	@Override
	public List<StateModel> findAllStates() {
		return (List<StateModel>) stateRepository.findAll();
	}

	@Override
	public Optional<StateModel> findStateById(int idState) {
		return stateRepository.findById(idState);
	}

	@Override
	public StateModel saveState(StateModel stateModel) {
		return stateRepository.save(stateModel);
	}

	@Override
	public boolean deleteState(int idState) {
		try {
			stateRepository.deleteById(idState);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}
}
