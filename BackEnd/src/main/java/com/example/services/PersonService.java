package com.example.services;

import com.example.models.Person;
import com.example.models.json.PersonView;
import com.example.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Validated
public interface PersonService {

    List<PersonView> getPersonByPersonalCodeAndBirthDate(Long personalCode, Date birthDate);
    List<PersonView> getPersons();
}
