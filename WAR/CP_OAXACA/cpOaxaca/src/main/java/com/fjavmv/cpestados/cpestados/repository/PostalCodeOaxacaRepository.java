package com.fjavmv.cpestados.cpestados.repository;

import com.fjavmv.cpestados.cpestados.modell.PostalCodeOaxacaModell;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostalCodeOaxacaRepository extends CrudRepository<PostalCodeOaxacaModell, Integer> {
	@Query(value = "SELECT * FROM oaxacacps WHERE d_codigo = ?1",nativeQuery = true)
	List<PostalCodeOaxacaModell> findPostalCodeOaxaca(int postalCode);

	@Query(value = "SELECT * FROM oaxacacps WHERE LOWER(d_asenta) LIKE CONCAT('%', LOWER(:asenta), '%')", nativeQuery = true)
	List<PostalCodeOaxacaModell> findPostalCodeByAsenta(@Param("asenta") String asenta);

}
