package com.riaddraoui.safetynet.service;

import com.riaddraoui.safetynet.model.DataWrapper;
import com.riaddraoui.safetynet.model.Person;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmailService {

    private final PersonService personService;

    public EmailService(PersonService personService) {
        this.personService = personService;
    }

    public List<String> getEmailsByCity(String city) throws IOException {
        DataWrapper dataWrapper = personService.readDataFromJSON();
        List<String> emails = dataWrapper.getPersons()
                .stream()
                .filter(person -> person.getCity().equalsIgnoreCase(city))
                .map(Person::getEmail)
                .distinct()
                .collect(Collectors.toList());

        return emails;
    }
}
