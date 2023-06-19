package com.coffeeandcode.repository;

import com.coffeeandcode.modell.SuneoModell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuneroRepository extends JpaRepository<SuneoModell, Integer> {

	@Query(value = "SELECT * FROM professions WHERE (LOWER(nameuniversity) LIKE LOWER(concat('%', :searchValue, '%'))) OR (LOWER(universitycampus) LIKE LOWER(concat('%', :searchValue, '%'))) OR (LOWER(degreeprogramoffered) LIKE LOWER(concat('%', :searchValue, '%')))", nativeQuery = true)
	List<SuneoModell> searchProfessions(@Param("searchValue") String searchValue);

}
