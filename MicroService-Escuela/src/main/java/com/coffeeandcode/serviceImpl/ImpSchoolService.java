package com.coffeeandcode.serviceImpl;

import com.coffeeandcode.modell.SchoolModell;
import com.coffeeandcode.repository.SchoolRepository;
import com.coffeeandcode.service.InterfaceSchoolService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImpSchoolService implements InterfaceSchoolService {
	private final SchoolRepository schoolRepository;

	public ImpSchoolService(@Autowired SchoolRepository schoolRepository) {
		this.schoolRepository = schoolRepository;
	}

	@Override
	public List<SchoolModell> listAllSchools() {

		return (List<SchoolModell>) schoolRepository.findAll();
	}

	@Override
	public Optional<SchoolModell> listSchoolById(int idSchool) {
		return schoolRepository.findById(idSchool);
	}


	@Override
	public SchoolModell saveSchool(SchoolModell schoolModell) {
		// Realizar la conversión del JSON a objeto de modelo
		Gson gson = new Gson();
		String jsonString = gson.toJson(schoolModell);
		SchoolModell modelFromJson = gson.fromJson(jsonString, SchoolModell.class);
		// Guardar el objeto de modelo en la base de datos
		SchoolModell savedSchool = schoolRepository.save(modelFromJson);
		//Devuelve el modelo que se almacenó
		return savedSchool;
	}

	@Override
	public int deleteSchool(int idSchool) {
		try {
			schoolRepository.deleteById(idSchool);
			return 1; // Eliminación exitosa
		} catch (EmptyResultDataAccessException e) {
			return 0; // No se encontró la entidad con el idSchool proporcionado
		} catch (Exception e) {
			return -1; // Ocurrió un error durante la eliminación
		}
	}

	@Override
	public List<SchoolModell> listSchoolsByName(String nameSchool) {
		return schoolRepository.searchByNameschool(nameSchool);
	}

	@Override
	public boolean deleteSchoolByName(String nameSchool) {
		int rowsAffected = schoolRepository.deleteSchoolByName(nameSchool);
		return rowsAffected > 0;
	}
}
