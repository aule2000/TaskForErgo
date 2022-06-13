package com.example.controllers;

import com.example.models.Gender;
import com.example.models.Person;
import com.example.models.json.PersonView;
import com.example.services.PersonServiceImpl;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonControllerTest {
    @InjectMocks
    PersonController personController;

    @Mock
    PersonServiceImpl personService;

    @Test
    void testShowAllPersonsList()
    {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1l,22l, "Juozas" ,"Juozukas", Gender.Female, Date.valueOf("2022-06-04")));
        personList.add(new Person(2l,223l, "Juozas1" ,"Juozukas", Gender.Female, Date.valueOf("2022-06-04")));
        when(personService.getPersons()).thenReturn(personList.stream().map(PersonView::of).collect(Collectors.toList()));

        List<PersonView> result = personController.getAllPersons();
        assertTrue(personList.size()==result.size());

    }
    @Test
    void testPersonsByPersonalCodeAndBirthDate() throws Exception
    {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1l,22l, "Juozas" ,"Juozukas", Gender.Female, Date.valueOf("2022-06-04")));
        when(personService.getPersonByPersonalCodeAndBirthDate(22l,java.sql.Date.valueOf("2022-06-04"))).thenReturn(personList.stream().map(PersonView::of).collect(Collectors.toList()));

        List<PersonView> result = personController.getPersonByPersonalCodeAndBirthDate(22l,Date.valueOf("2022-06-04"));
        assertTrue(personList.size()==result.size());
    }
}
