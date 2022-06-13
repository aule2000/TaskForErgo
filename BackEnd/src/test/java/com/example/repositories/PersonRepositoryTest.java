package com.example.repositories;

import com.example.models.Gender;
import com.example.models.Person;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class PersonRepositoryTest {
    @Autowired
    protected PersonRepository personRepository;
    @Test
    public void testFindAll()
    {
        Person person = new Person(36l, 60005175824l,"John" ,"Mile", Gender.Male, Date.valueOf("2022-06-04"));
        personRepository.save(person);
        Iterable<Person> persons = personRepository.findAll();
        assertNotNull(persons);
        List<Person> result = new ArrayList<>();
        persons.forEach(result::add);
        assertEquals(1, result.size());
    }
    @Test
    public void testFindByPersonalCodeAndBirthDate() {
        Person person = new Person(36l,60005175824l, "Mary" ,"Miles", Gender.Female, Date.valueOf("2022-06-04"));
        personRepository.save(person);

        Iterable<Person> persons = personRepository.findByPersonalCodeAndBirthDate(60005175824l, Date.valueOf("2022-06-04"));

        assertNotNull(persons);
        List<Person> result = StreamSupport.stream(persons.spliterator(), false).collect(Collectors.toList());

        assertEquals(1, result.size());
    }
}
