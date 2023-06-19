package com.coffeeandcode.service;

import com.coffeeandcode.modell.SchoolModell;

import java.util.List;
import java.util.Optional;

public interface InterfaceSchoolService {
	public List<SchoolModell> listAllSchools();

	public Optional<SchoolModell> listSchoolById(int idSchool);

	public SchoolModell saveSchool(SchoolModell schoolModell);

	public int deleteSchool(int idSchool);

	public List<SchoolModell> listSchoolsByName(String nameSchool);


	boolean deleteSchoolByName(String nameSchool);
}
