package com.coffeeandcode.repository;

import com.coffeeandcode.modell.LocationModell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LocationModell, Integer> {
	@Query(value = "SELECT idlocation FROM locations ORDER BY idlocation DESC LIMIT 1", nativeQuery = true)
	Long findLastLocationId();
}
