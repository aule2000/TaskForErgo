package com.example.services;

import com.example.models.Person;
import com.example.models.json.PersonView;
import com.example.repositories.PersonRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {
    @Mock
    PersonRepository personRepository;

    @InjectMocks
    PersonServiceImpl personServiceImpl;
    @Test
    void testFindByPersonalCodeAndBirthDate() {
        Person person = new Person(0l,60005175824l,"","",null, java.sql.Date.valueOf("2022-04-04"));
        List<Person> persons = new ArrayList<>();
        persons.add(person);
        Date currentDate = new Date();
        when(personRepository.findByPersonalCodeAndBirthDate(60005175824l,currentDate)).thenReturn(persons);
        List<PersonView> found = personServiceImpl.getPersonByPersonalCodeAndBirthDate(60005175824l,currentDate);
        verify(personRepository).findByPersonalCodeAndBirthDate(60005175824l,currentDate);
        assertEquals(1, found.size());

    }
    @DisplayName("Test Find All")
    @Test
    void testFindAll() {
        Person person = new Person(0l,60005175824l,"","",null,java.sql.Date.valueOf("2022-04-04"));
        List<Person> persons = new ArrayList<>();
        persons.add(person);

        when(personRepository.findAll()).thenReturn(persons);
        List<PersonView> found = personServiceImpl.getPersons();
        verify(personRepository).findAll();
        assertEquals(1, found.size());

    }
}
