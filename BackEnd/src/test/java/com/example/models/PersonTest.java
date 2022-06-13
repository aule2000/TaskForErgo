package com.example.models;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void testSetId() {
        Person person = new Person();
        person.setId(2l);
        long value = person.getId();
        assertEquals(value,2l);
    }
    @Test
    void testSetPersonalCode() {
        Person person = new Person();
        person.setPersonalCode(21452563254l);
        long value = person.getPersonalCode();
        assertEquals(value,21452563254l);
    }
    @Test
    void testSetFirstName() {
        Person person = new Person();
        person.setFirstName("Name");
        String value = person.getFirstName();
        assertEquals(value,"Name");
    }
    @Test
    void testSetLastName() {
        Person person = new Person();
        person.setLastName("lastName");
        String value = person.getLastName();
        assertEquals(value,"lastName");
    }

    @Test
    void testSetGender() {
        Person person = new Person();
        person.setGender(Gender.Female);
        Gender value = person.getGender();
        assertEquals(value,Gender.Female);
    }
    @Test
    void testSetBirthDate() {
        Person person = new Person();
        Date currentDate = new Date();
        person.setBirthDate(currentDate);
        Date date = person.getBirthDate();
        assertEquals(date,currentDate);
    }


}
