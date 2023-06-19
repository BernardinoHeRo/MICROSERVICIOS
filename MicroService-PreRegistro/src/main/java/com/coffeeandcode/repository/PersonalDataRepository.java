package com.coffeeandcode.repository;

import com.coffeeandcode.model.PersonalDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDataRepository extends JpaRepository<PersonalDataModel, Integer> {
}
