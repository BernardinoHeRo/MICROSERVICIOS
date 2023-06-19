package com.coffeeandcode.repository;

import com.coffeeandcode.model.AcademicDataModel;
import com.coffeeandcode.model.TutorsInformationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorsInformationRepository extends JpaRepository<TutorsInformationModel, Integer> {
}
