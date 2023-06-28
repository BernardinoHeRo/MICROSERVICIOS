package com.coffeeandcode.repository;

import com.coffeeandcode.model.CologneModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CologneRepository extends JpaRepository<CologneModel, Integer> {
	@Query(value = "SELECT * FROM colonias WHERE codigo_postal = :postalCode", nativeQuery = true)
	List<CologneModel> findByPostalCode(@Param("postalCode") int postalCode);

}
