package com.coffeeandcode.service;

import com.coffeeandcode.model.PostalCodeModel;

import java.util.List;
import java.util.Optional;

public interface InterPostalCodeService {
	public List<PostalCodeModel> findAllPostalCodes();
	public Optional<PostalCodeModel> findPostalCodeById(int idPostalCode);
	public PostalCodeModel savePostalCode(PostalCodeModel postalCodeModel);
	public boolean deletePostalCode(int idPostalCode);
	public List<PostalCodeModel> findPostalCodesByPostalCode(int postalCode);
}
