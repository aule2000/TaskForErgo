package com.example.models.json;

import com.example.models.Gender;
import com.example.models.Person;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class PersonView {
    private Long personalCode;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Date birthDate;

    public static PersonView of(Person person) {
        return PersonView.builder()
                .personalCode(person.getPersonalCode())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .gender(person.getGender())
                .birthDate(person.getBirthDate())
                .build();
    }
}
