package com.coffeeandcode.repository;

import com.coffeeandcode.model.PostalCodeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostalCodeRepository extends JpaRepository<PostalCodeModel, Integer> {
	@Query(value = "SELECT * FROM cat_cp WHERE cp = :postalCode", nativeQuery = true)
	List<PostalCodeModel> findByCp(@Param("postalCode") int postalCode);
}
