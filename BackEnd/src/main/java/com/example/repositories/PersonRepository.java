package com.example.repositories;

import com.example.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByPersonalCodeAndBirthDate(@Param("personalCode") Long personalCode, @Param("birthDate") Date birthDate);
}

