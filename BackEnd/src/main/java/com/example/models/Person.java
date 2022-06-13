package com.example.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private Long personalCode;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    @NonNull
    private Date birthDate;
}
