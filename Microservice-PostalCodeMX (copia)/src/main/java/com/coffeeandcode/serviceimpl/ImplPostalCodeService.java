package com.coffeeandcode.serviceimpl;

import com.coffeeandcode.model.PostalCodeModel;
import com.coffeeandcode.repository.PostalCodeRepository;
import com.coffeeandcode.service.InterPostalCodeService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplPostalCodeService implements InterPostalCodeService {
	private final PostalCodeRepository postalCodeRepository;

	public ImplPostalCodeService(PostalCodeRepository postalCodeRepository) {
		this.postalCodeRepository = postalCodeRepository;
	}

	@Override
	public List<PostalCodeModel> findAllPostalCodes() {
		return (List<PostalCodeModel>) postalCodeRepository.findAll();
	}

	@Override
	public Optional<PostalCodeModel> findPostalCodeById(int idPostalCode) {
		return postalCodeRepository.findById(idPostalCode);
	}

	@Override
	public PostalCodeModel savePostalCode(PostalCodeModel postalCodeModel) {
		return postalCodeRepository.save(postalCodeModel);
	}

	@Override
	public boolean deletePostalCode(int idPostalCode) {
		try {
			postalCodeRepository.deleteById(idPostalCode);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}

	@Override
	public List<PostalCodeModel> findPostalCodesByPostalCode(int postalCode) {
		List<PostalCodeModel> postalCodes = postalCodeRepository.findByCp(postalCode);
		for (PostalCodeModel postalCodeModel : postalCodes) {
			System.out.println(postalCodeModel);
		}
		return postalCodes;
	}


}
