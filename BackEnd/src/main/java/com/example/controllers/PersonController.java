package com.example.controllers;

import com.example.models.json.PersonView;
import com.example.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/person/{personalCode}/{birthDate}")
    public List<PersonView> getPersonByPersonalCodeAndBirthDate(@PathVariable(value = "personalCode") Long personalCode,
                                                 @PathVariable(value = "birthDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthDate)
    {
        return personService.getPersonByPersonalCodeAndBirthDate(personalCode, birthDate);
    }
    @GetMapping("/persons")
    public List<PersonView> getAllPersons(){
        return personService.getPersons();
    }

}
