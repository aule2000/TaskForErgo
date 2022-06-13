package com.example.services;

import com.example.exceptions.NotFoundException;
import com.example.models.Person;
import com.example.models.json.PersonView;
import com.example.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{
    private final PersonRepository personRepository;

    @Override
    public List<PersonView> getPersonByPersonalCodeAndBirthDate(Long personalCode, Date birthDate)
    {
        List<Person> persons = personRepository.findByPersonalCodeAndBirthDate(personalCode,birthDate);
        if (persons.isEmpty()){
            throw new NotFoundException("No persons was found");
        }
            return persons.stream().map(PersonView::of).collect(Collectors.toList());

    }

    @Override
    public List<PersonView> getPersons(){
        List<Person> persons =  personRepository.findAll();
        if (persons.isEmpty()){
            throw new NotFoundException("No persons was found");
        }
        return persons.stream().map(PersonView::of).collect(Collectors.toList());
    }
}
