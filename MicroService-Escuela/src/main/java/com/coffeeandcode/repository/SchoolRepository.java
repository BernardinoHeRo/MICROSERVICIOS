package com.coffeeandcode.repository;

import com.coffeeandcode.modell.SchoolModell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<SchoolModell, Integer> {
	@Query(value = "SELECT * FROM highschools WHERE nameschool LIKE CONCAT('%', :nameSchool, '%')", nativeQuery = true)
	public List<SchoolModell> searchByNameschool(@Param("nameSchool") String nameSchool);

	@Query(value = "DELETE FROM highschools WHERE nameschool = ?1", nativeQuery = true)
	public int deleteSchoolByName(String schoolName);


}
