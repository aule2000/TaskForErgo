package com.example.controllers;

import com.example.TaskApplication;
import com.example.services.PersonServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(classes = TaskApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerITTest {
    @LocalServerPort
    private int port;


    @Autowired
    PersonServiceImpl service;


    @Test
    void test() {
        System.out.println("PORT=" + port);
    }
    @Test
    void testFindPersonByIdAndBirthDate() throws Exception{
        String expected = "[{\"id\":34,\"personalCode\":99999999999,\"firstName\":\"bla\",\"lastName\":\"sda\",\"gender\":\"Male\",\"birthDate\":1654549200000}]";
                WebTestClient
                .bindToServer()
                .baseUrl("http://localhost:"+port)
                .build()
                .get()
                .uri("/person/99999999999/2022-06-07")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().valueEquals("Content-Type", "application/json")
                .expectBody().json(expected);

    }
}
