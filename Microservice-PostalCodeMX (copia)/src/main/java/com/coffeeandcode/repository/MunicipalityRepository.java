package com.coffeeandcode.repository;

import com.coffeeandcode.model.MunicipalityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipalityRepository extends JpaRepository<MunicipalityModel, Integer> {
}
