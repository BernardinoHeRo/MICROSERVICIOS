package com.fjavmv.cpestados.cpestados.serviceImpl;


import com.fjavmv.cpestados.cpestados.modell.PostalCodeOaxacaModell;
import com.fjavmv.cpestados.cpestados.repository.PostalCodeOaxacaRepository;
import com.fjavmv.cpestados.cpestados.services.InterfacePostalCodeOaxacaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplPostalcodeOaxacaService implements InterfacePostalCodeOaxacaService {
	private final PostalCodeOaxacaRepository postalCodeOaxacaRepository;

	public ImplPostalcodeOaxacaService(PostalCodeOaxacaRepository postalCodeOaxacaRepository) {
		this.postalCodeOaxacaRepository = postalCodeOaxacaRepository;
	}

	@Override
	public List<PostalCodeOaxacaModell> listAllPostalCodesOaxaca() {
		return (List<PostalCodeOaxacaModell>) postalCodeOaxacaRepository.findAll();
	}

	@Override
	public List<PostalCodeOaxacaModell> listAllPostalCodesByPostalCode(int postalCode) {
		List<PostalCodeOaxacaModell> postalCodeOaxacaModellList = (List<PostalCodeOaxacaModell>) postalCodeOaxacaRepository.findPostalCodeOaxaca(postalCode);
		return postalCodeOaxacaModellList;
	}

	@Override
	public List<PostalCodeOaxacaModell> listAllPostalCodesByAsenta(String asenta) {
		return postalCodeOaxacaRepository.findPostalCodeByAsenta(asenta);
	}
}
