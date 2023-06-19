package com.coffeeandcode.serviceimpl;

import com.coffeeandcode.model.DegreeDetailsModel;
import com.coffeeandcode.repository.DegreeDetailsRepository;
import com.coffeeandcode.service.InterfaceDegreeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ImplDegreeDetailsService implements InterfaceDegreeDetailsService {
	private final DegreeDetailsRepository degreeDetailsRepository;

	@Autowired
	public ImplDegreeDetailsService(DegreeDetailsRepository degreeDetailsRepository) {
		this.degreeDetailsRepository = degreeDetailsRepository;
	}

	@Override
	public List<DegreeDetailsModel> listallDegreeDetail() {
		return degreeDetailsRepository.findAll();
	}

	@Override
	public Optional<DegreeDetailsModel> getDegreeDetailById(int idDegreeDetail) {
		return degreeDetailsRepository.findById(idDegreeDetail);
	}

	@Override
	public DegreeDetailsModel createDegreeDetail(DegreeDetailsModel DegreeDetailsModel) {
		return null;
	}

	@Override
	public DegreeDetailsModel saveDegreeDetail(DegreeDetailsModel degreeDetailsModel) {
		return degreeDetailsRepository.save(degreeDetailsModel);
	}


	@Override
	public DegreeDetailsModel updateDegreeDetail(int idDegreeDetail, DegreeDetailsModel degreeDetailsModel) {
		Optional<DegreeDetailsModel> degreeDetailsModelOptional = degreeDetailsRepository.findById(idDegreeDetail);

		if (degreeDetailsModelOptional.isPresent()) {
			DegreeDetailsModel existingDegreeDetail = degreeDetailsModelOptional.get();
			/*
			// Actualizar los campos necesarios en el objeto existingPersonalData
			existingPersonalData.setApplicantsname(DegreeDetailsModel.getApplicantsname());
			existingPersonalData.setSurname(DegreeDetailsModel.getSurname());
			existingPersonalData.setCurp(DegreeDetailsModel.getCurp());
			existingPersonalData.setDateofbirth(DegreeDetailsModel.getDateofbirth());
			existingPersonalData.setPlaceofbirth(DegreeDetailsModel.getPlaceofbirth());
			// Actualizar otras propiedades si es necesario
*/
			// Guardar los cambios en la base de datos
			DegreeDetailsModel degreeDetailsModel1 = degreeDetailsRepository.save(existingDegreeDetail);
			return degreeDetailsModel1;
		} else {
			throw new NoSuchElementException("El modelo para el ID " + idDegreeDetail + " no existe");
		}
	}


	@Override
	public boolean deleteDegreeDetail(int idDegreeDetail) {
		Optional<DegreeDetailsModel> degreeDetailsModel = degreeDetailsRepository.findById(idDegreeDetail);

		if (degreeDetailsModel.isPresent()) {
			degreeDetailsRepository.deleteById(idDegreeDetail);
			return true;
		} else {
			return false;
		}
	}
}
