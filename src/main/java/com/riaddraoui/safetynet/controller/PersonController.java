package com.riaddraoui.safetynet.controller;

import com.riaddraoui.safetynet.model.Person;
import com.riaddraoui.safetynet.service.PersonInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class PersonController {
    private final PersonInfoService personInfoService;

    public PersonController(PersonInfoService personInfoService) {
        this.personInfoService = personInfoService;
    }

    @GetMapping("/personInfo")
    public List<Person> getPersons(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName
    ) throws IOException {
        if (firstName != null && lastName != null) {
            return personInfoService.getPersonInfoByFirstNameAndLastName(firstName, lastName);
        } else {
            return personInfoService.getPersonInfo();
        }
    }
}
