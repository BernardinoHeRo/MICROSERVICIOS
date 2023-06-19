package com.coffeeandcode.repository;

import com.coffeeandcode.model.AcademicDataModel;
import com.coffeeandcode.model.DegreeDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeDetailsRepository extends JpaRepository<DegreeDetailsModel, Integer> {
}
