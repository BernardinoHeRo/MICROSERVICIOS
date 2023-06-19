package com.coffeeandcode.repository;

import com.coffeeandcode.model.AcademicDataModel;
import com.coffeeandcode.model.DateContactModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateContactRepository extends JpaRepository<DateContactModel, Integer> {
}
